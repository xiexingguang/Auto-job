/**
 * Project Name:autoJob
 * File Name:CollectMsg.java
 * Package Name:com.ec.autojob.collectJob
 * Date:2015年6月24日上午11:50:47
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.collectJob.core;
/**
 * ClassName:CollectMsg <br/>
 * Function: 
 * 因为收集数据来源可能为日志，也可能为
 * 其他数据源，所有抽象出接口来
 *  <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月24日 上午11:50:47 <br/>
 * @author   ecuser
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface CollectMsgInterface {
	
	/**
	 * 
	 * collectMsg:(真正执行日志数据业务逻辑的地方). <br/>
	 
	 * @author ecuser
	 * @since JDK 1.7
	 */
	public  void   collectMsg();

}

