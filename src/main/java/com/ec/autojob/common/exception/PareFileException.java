/**
 * Project Name:autoJob
 * File Name:PareFileException.java
 * Package Name:com.ec.autojob.common.exception
 * Date:2015年6月24日下午7:09:24
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.common.exception;
/**
 * ClassName:PareFileException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月24日 下午7:09:24 <br/>
 * @author   ecuser
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class PareFileException  extends RuntimeException{
	
	 
	 /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.7
	 */
	private static final long serialVersionUID = 1L;
	
	public PareFileException(String msg){
		  super(msg);
		 
	 }
	 public PareFileException(String msg ,Throwable t){
		 super(msg, t);
	 }
    
	 
}

