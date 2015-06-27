/**
 * Project Name:autoJob
 * File Name:StaticMsgListener.java
 * Package Name:com.ec.autojob.staticJob.core
 * Date:2015年6月25日下午2:47:26
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.staticJob.listener;
/**
 * ClassName:StaticMsgListener <br/>
 * Function  统计监听器<br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月25日 下午2:47:26 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface StaticMsgListener {
	
	/**
	 * 
	 * before:执行统计数之前的业务逻辑操作<br/>
	 * @author xxg
	 * @since JDK 1.7
	 */
	public void before();
	/**
	 * 
	 * after:统计数据之后的业务逻辑操作 <br/>
	 * @author xxg
	 * @param t
	 * @since JDK 1.7
	 */
	public  <T> void after(T t);
	/**
	 * 
	 * handleException: 处理统计任务出现的异常<br/>
	 * @author xxg
	 * @since JDK 1.7
	 */
	public void handleException(Throwable t);

}

