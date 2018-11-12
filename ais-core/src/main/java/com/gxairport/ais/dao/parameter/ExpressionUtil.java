package com.gxairport.ais.dao.parameter;

import com.gxairport.ais.enums.QueryGroupDate;
import com.gxairport.ais.exception.ComposeException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;


/**
 * FileName      ExpressionUtil.java
 * Description  TODO JPA安全表达式工具类，主要用于表达式的解析
 *
 * @author ZhangYu    Company:    gxAirport
 * @version V1.0 CreateDate: 2017年6月22日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月22日      ZhangYu    1.0   create
 * Why  What is modified:
 */


public class ExpressionUtil {

    private final static int START_YEAR_POS = 1;

    private final static int START_MONTH_POS = 6;

    private final static int START_DAY_POS = 6;

    private final static int YEAR_LEN = 4;

    private final static int MONTH_LEN = 2;

    private final static int DAY_LEN = 5;


    /**
     * 操作符对比动作
     */
    private final static String CALC = "calc";

    private final static String POP = "pop";

    private final static String PUSH = "push";

    private final static String ERROR = "err";


    /**
     * 优先级定义表
     */
    private Map<String, Map<String, String>> priorityMap = new HashMap<>();

    private List<String> opts = Arrays.asList(">", "<", ">=", "<=", "<>", "=", "LIKE", "IS", "+", "-", "OR", "AND", "(", ")", "#");

    /**
     * 存放条件表达式的栈
     */
    private Stack<Object> dataStack = new Stack<>();

    /**
     * 存放操作符的栈
     */
    private Stack<String> optStack = new Stack<>();


    private CriteriaBuilder cb;


    /**
     * Description: 初始化优先级定义表
     * (OR)<(AND)<(>,<,>=,<=,<>,LIKE)<(())
     */
    private void initPriorityMap() {

        //>
        Map<String, String> map = new HashMap<>();
        map.put(">", CALC);
        map.put("<", CALC);
        map.put(">=", CALC);
        map.put("<=", CALC);
        map.put("<>", CALC);
        map.put("=", CALC);
        map.put("LIKE", CALC);
        map.put("IS", CALC);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put(">", map);
        //<
        map.clear();
        map.put(">", CALC);
        map.put("<", CALC);
        map.put(">=", CALC);
        map.put("<=", CALC);
        map.put("=", CALC);
        map.put("<>", CALC);
        map.put("LIKE", CALC);
        map.put("IS", CALC);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put("<", map);

        //>=
        map.clear();
        map.put(">", CALC);
        map.put("<", CALC);
        map.put(">=", CALC);
        map.put("<=", CALC);
        map.put("=", CALC);
        map.put("<>", CALC);
        map.put("LIKE", CALC);
        map.put("IS", CALC);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put(">=", map);

        //<=
        map.clear();
        map.put(">", CALC);
        map.put("<", CALC);
        map.put(">=", CALC);
        map.put("<=", CALC);
        map.put("=", CALC);
        map.put("<>", CALC);
        map.put("LIKE", CALC);
        map.put("IS", CALC);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put("<=", map);
        //<>
        map.clear();
        map.put(">", CALC);
        map.put("<", CALC);
        map.put(">=", CALC);
        map.put("<=", CALC);
        map.put("=", CALC);
        map.put("<>", CALC);
        map.put("LIKE", CALC);
        map.put("IS", CALC);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put("<>", map);

        //=
        map.clear();
        map.put(">", CALC);
        map.put("<", CALC);
        map.put(">=", CALC);
        map.put("<=", CALC);
        map.put("=", CALC);
        map.put("<>", CALC);
        map.put("LIKE", CALC);
        map.put("IS", CALC);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put("=", map);

        //LIKE
        map.clear();
        map.put(">", CALC);
        map.put("<", CALC);
        map.put(">=", CALC);
        map.put("<=", CALC);
        map.put("=", CALC);
        map.put("<>", CALC);
        map.put("LIKE", CALC);
        map.put("IS", CALC);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put("LIKE", map);

        //IS
        map.clear();
        map.put(">", CALC);
        map.put("<", CALC);
        map.put(">=", CALC);
        map.put("<=", CALC);
        map.put("=", CALC);
        map.put("<>", CALC);
        map.put("LIKE", CALC);
        map.put("IS", CALC);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put("IS", map);

        //+
        map.clear();
        map.put(">", CALC);
        map.put("<", CALC);
        map.put(">=", CALC);
        map.put("<=", CALC);
        map.put("=", CALC);
        map.put("<>", CALC);
        map.put("LIKE", CALC);
        map.put("IS", CALC);
        map.put("+", CALC);
        map.put("-", CALC);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put("+", map);

        //-
        map.clear();
        map.put(">", CALC);
        map.put("<", CALC);
        map.put(">=", CALC);
        map.put("<=", CALC);
        map.put("=", CALC);
        map.put("<>", CALC);
        map.put("LIKE", CALC);
        map.put("IS", CALC);
        map.put("+", CALC);
        map.put("-", CALC);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put("-", map);

        //OR
        map.clear();
        map.put(">", PUSH);
        map.put("<", PUSH);
        map.put(">=", PUSH);
        map.put("<=", PUSH);
        map.put("=", PUSH);
        map.put("<>", PUSH);
        map.put("LIKE", PUSH);
        map.put("IS", PUSH);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", CALC);
        map.put("AND", PUSH);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put("OR", map);

        //AND
        map.clear();
        map.put(">", PUSH);
        map.put("<", PUSH);
        map.put(">=", PUSH);
        map.put("<=", PUSH);
        map.put("=", PUSH);
        map.put("<>", PUSH);
        map.put("LIKE", PUSH);
        map.put("IS", PUSH);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", CALC);
        map.put("AND", CALC);
        map.put("(", PUSH);
        map.put(")", CALC);
        map.put("#", CALC);
        priorityMap.put("AND", map);
        //(
        map.clear();
        map.put(">", PUSH);
        map.put("<", PUSH);
        map.put(">=", PUSH);
        map.put("<=", PUSH);
        map.put("=", PUSH);
        map.put("<>", PUSH);
        map.put("LIKE", PUSH);
        map.put("IS", PUSH);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", PUSH);
        map.put("AND", PUSH);
        map.put("(", PUSH);
        map.put(")", POP);
        map.put("#", ERROR);
        priorityMap.put("(", map);

        //) 不可能被放入栈中，一定会被丢弃，因为前面的数据一定会被计算
        map.clear();
        map.put(">", ERROR);
        map.put("<", ERROR);
        map.put(">=", ERROR);
        map.put("<=", ERROR);
        map.put("<>", ERROR);
        map.put("=", ERROR);
        map.put("LIKE", ERROR);
        map.put("IS", ERROR);
        map.put("+", ERROR);
        map.put("-", ERROR);
        map.put("OR", ERROR);
        map.put("AND", ERROR);
        map.put("(", ERROR);
        map.put(")", ERROR);
        map.put("#", ERROR);
        priorityMap.put(")", map);
        //# 结束和开始字符
        map.clear();
        map.put(">", PUSH);
        map.put("<", PUSH);
        map.put(">=", PUSH);
        map.put("<=", PUSH);
        map.put("=", PUSH);
        map.put("<>", PUSH);
        map.put("LIKE", PUSH);
        map.put("IS", PUSH);
        map.put("+", PUSH);
        map.put("-", PUSH);
        map.put("OR", PUSH);
        map.put("AND", PUSH);
        map.put("(", PUSH);
        map.put(")", ERROR);
        map.put("#", POP);
        priorityMap.put("#", map);

    }

    public ExpressionUtil(CriteriaBuilder cb) {
        super();
        this.cb = cb;
        initPriorityMap();
    }

    private boolean isOpt(String token) {
        return opts.indexOf(token) != -1;
    }


    /**
     * Description    TODO 将操作数据根据操作符进行合并
     *
     * @param obj_1 操作数据1
     * @param obj_2 操作数据2
     * @param opt   操作符
     * @return 合并后的表达式、值
     * @throws ComposeException 抛出无法进行合并的异常
     */
    @SuppressWarnings({"unchecked"})
    private Object compose(Object obj_1, Object obj_2, String opt) throws ComposeException {


        if (obj_1 instanceof Predicate && obj_2 instanceof Predicate) {

            /*
             * 对两个条件进行对应的操作
             */
            switch (opt) {

                case "AND":
                    return cb.and((Predicate) obj_1, (Predicate) obj_2);

                case "OR":
                    return cb.or((Predicate) obj_1, (Predicate) obj_2);
            }

        } else if (obj_1 instanceof Expression && obj_2 instanceof Expression) {

            /*
             *  对两个表达式进行对应的操作
             */
            switch (opt) {

                case "+":
                    return cb.sum((Expression) obj_1, (Expression) obj_2);

                case "-":
                    return cb.sum((Expression) obj_1, (Expression) obj_2);
            }


        } else if (obj_2 instanceof Expression && obj_1 instanceof Comparable) {

            /*
             *  如果一个是表达式，一个是数据对象（可比较）
             */
            switch (opt) {

                case ">":
                    return cb.greaterThan((Expression) obj_2, (Comparable) obj_1);

                case "<":
                    return cb.lessThan((Expression) obj_2, (Comparable) obj_1);

                case ">=":
                    return cb.greaterThanOrEqualTo((Expression) obj_2, (Comparable) obj_1);

                case "<=":
                    return cb.lessThanOrEqualTo((Expression) obj_2, (Comparable) obj_1);
            }
        } else if (obj_2 instanceof Expression) {
            /*
             *  如果一个是表达式，一个是数据对象（不可比较）
             */
            switch (opt) {

                case "=":
                    return cb.equal((Expression) obj_2, obj_1);

                case "<>":
                case "!=":
                    return cb.notEqual((Expression) obj_2, obj_1);

                case "LIKE":
                    return cb.like((Expression) obj_2, obj_1.toString());

                case "IS":
                    if ("NULL".equals(obj_1)) {
                        return cb.isNull((Expression) obj_2);
                    } else {
                        return cb.isNotNull((Expression) obj_2);
                    }
            }
        }

        /*
         * 如果执行到这，说明没有发生返回，则抛出异常
         */
        throw new ComposeException("栈内参数出错，无法进行合成");


    }

    /**
     * Description: TODO    进行入栈出栈的操作
     *
     * @param token 操作符
     * @throws Exception 异常抛出
     */
    private void process(String token) throws ComposeException {
        while (!optStack.peek().equals("#") || !"#".equals(token)) {
            //如果操作符栈顶为#，表达式传入对象为#，说明已经处理完表达式，跳出循环
            if (!isOpt(token)) {
                //表达式不是操作符，入栈，跳出循环，进行下一个表达式的处理
                dataStack.push(token);
                break;
            } else if (optStack.size() > 0) {
                String priority = priorityMap.get(optStack.peek()).get(token);
                if (PUSH.equals(priority)) {
                    //如果操作符的等级比栈内的操作符的等级高，将此操作符入栈，并跳出循环
                    optStack.push(token);
                    break;
                } else if (POP.equals(priority)) {
                    //说明是一对括号，中间的数据已经处理完毕，跳出循环，丢弃括号
                    optStack.pop();
                    break;
                } else if (CALC.equals(priority)) {
                    //说明操作符等级比栈内的低，处理栈内的数据运算，直到跳出循环
                    if (dataStack.size() >= 2) {
                        Object obj = compose(dataStack.pop(), dataStack.pop(), optStack.pop());
                        dataStack.push(obj);
                    } else {
                        throw new ComposeException("数据栈内数据不足，请检查表达式");
                    }
                } else {

                    throw new ComposeException("表达式出错，请检查表达式");
                }
            } else {
                throw new ComposeException("操作符栈内数据不足，请检查表达式");
            }

        }
    }

    /**
     * Description:    TODO         进行表达式的解析
     *
     * @param <T>        泛型表达
     * @param expression 表达式
     * @return 解析后的结果
     * @throws ComposeException 传递抛出的额异常
     */
    @SuppressWarnings("unchecked")
    public <T> T composeExpression(Object[] expression) throws ComposeException {
        optStack.push("#");
        for (Object token : expression) {
            process(token.toString());
        }
        process("#");
        return (T) dataStack.pop();

    }


    /**
     * Description: TODO 根据QueryGroupDate的值对表达式进行日期类型的截取
     *
     * @param ymd        QueryGroupDate的值，一般是年，月，日
     * @param expression 表达式
     * @return 返回截取的表达式，如果不在QueryGroupDate的范围内，则返回为空
     */
    @SuppressWarnings("unchecked")
    public Expression getYMDExpression(QueryGroupDate ymd, Expression expression) {
        switch (ymd) {
            case year:
                return cb.substring(expression, START_YEAR_POS, YEAR_LEN);
            case month:
                return cb.substring(expression, START_MONTH_POS, MONTH_LEN);
            case day:
                return cb.substring(expression, START_DAY_POS, DAY_LEN);
        }
        return null;
    }

}
