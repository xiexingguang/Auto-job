/**
 * Project Name:autoJob
 * File Name:WriteStringToLogException.java
 * Package Name:com.ec.autojob.common.exception
 * Date:2015年6月25日上午10:25:17
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.common.exception;
/**
 * ClassName:WriteStringToLogException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月25日 上午10:25:17 <br/>
 * @author  xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class WriteStringToLogException extends RuntimeException{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.7
	 */
	private static final long serialVersionUID = 1L;
	
	public WriteStringToLogException(String msg,Throwable t){
		 super(msg, t);
	}

}

