/**
 * Project Name:autoJob
 * File Name:AayLengthNotEqObFileNumsException.java
 * Package Name:com.ec.autojob.common.exception
 * Date:2015年6月25日上午9:21:35
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.common.exception;
/**
 * ClassName:AayLengthNotEqObFileNumsException <br/>
 * Function: 
 * 
 *  因为要解析日志报文日志报文格式为：xxxg||wer||23123||wewr
 *  解析一条记录放在string[] 数组中。将该数组与实体java bean进行映射
 *  可能出现数组与实体bean中的属性数量不等
 *  br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月25日 上午9:21:35 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class AayLengthNotEqObFileNumsException extends RuntimeException {
	
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.7
	 */
	private static final long serialVersionUID = 1L;

	public AayLengthNotEqObFileNumsException(){
		 super();
		
	}
	
	public AayLengthNotEqObFileNumsException(String msg){
		  super(msg);
	}
  
	public AayLengthNotEqObFileNumsException(String msg,Throwable t){
		  super(msg, t);
	}
}

