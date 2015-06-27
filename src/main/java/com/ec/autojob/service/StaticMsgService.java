/**
 * Project Name:autoJob
 * File Name:StaticMsgService.java
 * Package Name:com.ec.autojob.service
 * Date:2015年6月24日下午4:33:31
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.service;
/**
 * ClassName:StaticMsgService <br/>
 * Function: 
 * 统计service，跟业务逻辑紧密相连，根据不同业务
 * 数据要进行统计，从不同维度去统计，最后生成统计结果
 *  
 *  <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月24日 下午4:33:31 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface StaticMsgService {
	  
	  /**
	   * 
	   * handlerStaticData:统计<br/>
	   * TODO(这里描述这个方法适用条件 – 可选).<br/>
	   * @author xxg
	   * @param colletcionName :集合名称，或者表名,目前业务设计是一天的消息数据放在一个集合里面，这样
	   * 统计的就为一天的数据
	   * @param t 统计结果记录，以bean的形式返回
	   * @return
	   * @since JDK 1.7
	   */
	  public <T> T handlerStaticData(String colletcionName,T t);

}

