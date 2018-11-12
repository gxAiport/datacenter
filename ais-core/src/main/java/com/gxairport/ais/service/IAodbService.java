package com.gxairport.ais.service;

import javax.ejb.Remote;

/**
 * FileName      IAodbService.java
 * Description   TODO  Aodb服务层接口
 *
 * @author ZhangYu    Company:    LZAirport
 * @version V0.9a CreateDate: 2017年6月24日
 * ModificationHistory
 * Date         Author     Version   Description
 * ---------------------------------------------
 * 2017年6月24日      ZhangYu    1.0        1.0
 * Why  What is modified:
 */

@Remote
public interface IAodbService<K, E> extends IService<K, E> {

}
