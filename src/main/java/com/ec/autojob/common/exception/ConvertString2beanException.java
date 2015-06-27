/**
 * Project Name:autoJob
 * File Name:ConvertString2beanException.java
 * Package Name:com.ec.autojob.common.exception
 * Date:2015年6月24日下午6:58:53
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.common.exception;
/**
 * ClassName:ConvertString2beanException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月24日 下午6:58:53 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class ConvertString2beanException  extends RuntimeException{
	
	 /**
	 * serialVersionUID:.
	 * @since JDK 1.7
	 */
	private static final long serialVersionUID = 1L;

	public ConvertString2beanException(){
		 super();
	 }
		
	  public ConvertString2beanException(String msg){
		  super(msg);
	  }
	  
	  public ConvertString2beanException(String msg ,Throwable t){
		 super(msg, t);
	  }

}

