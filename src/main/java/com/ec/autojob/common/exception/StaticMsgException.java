/**
 * Project Name:autoJob
 * File Name:StaticMsgException.java
 * Package Name:com.ec.autojob.common.exception
 * Date:2015年6月25日下午5:47:04
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.common.exception;
/**
 * ClassName:StaticMsgException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月25日 下午5:47:04 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class StaticMsgException extends RuntimeException{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.7
	 */
	private static final long serialVersionUID = 1L;
   
	public StaticMsgException(String msg,Throwable t){
	    	 super(msg, t);
	}
	
}

