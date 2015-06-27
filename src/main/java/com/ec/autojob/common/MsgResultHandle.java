/**
 * Project Name:autoJob
 * File Name:MsgResultHandle.java
 * Package Name:com.ec.autojob.common
 * Date:2015年6月24日下午2:59:35
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.common;
/**
 * ClassName:MsgResultHandle <br/>
 * Function: 
 * 这个类作用为处理2类结果数据：<br/>
 * 1.统计收集到的数据怎么处理？每条日志记录信息会被被映射成java对象。<br/>
 * 2.统计后的展示数据该怎么处理？<br/>
 * 抽象该接口，方便扩展。以后的结果数据可以入mongo库，也可以放到redis<br/>
 * 也可以放到mysql，只要实现不同的handle即可<br/>
 * 收集数据和统计数据结果公用 <br/>
 * Date:     2015年6月24日 下午2:59:35 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface MsgResultHandle {
	
	/**
	 * 
	 * handleMsgBean:(消息结果bean处理类，就是将消息映射成一个普通的javabean对象时，对这个对象的操作流程). <br/>
	 * @author xxg
	 * @param  收集日志记录每条字符串最后转换成一个bean对象。由于bean对象不是固定的，目前我们日志bean对象为LogMsgBean，
	 * 如果以后日志格式改变，用泛型T解决这一问题。这样我们不仅可以统计消息日志格式数据，我们还可以统计其他类型
	 * 
	 * @since JDK 1.7
	 */
	 public <T> void handleMsgBean(T t) ;

}

