package com.gxairport.ais.service;

import javax.ejb.Remote;

/**
 * FileName      IGeneralService.java
 * Description  TODO 通常的服务层接口
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V1.0 CreateDate: 2017年6月26日
 * ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月26日      ZhangYu    1.0   create
 * <p>Why  What is modified:
 */
@Remote
public interface IGeneralService<K, E> extends IService<K, E> {

}
