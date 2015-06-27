/**
 * Project Name:autoJob
 * File Name:PareDataRule.java
 * Package Name:com.ec.autojob.collectJob
 * Date:2015年6月24日上午10:38:57
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.collectJob.core;
/**
 * ClassName:PareDataRule <br/>
 * Function: T
 * 数据解析规则接口，
 * 针对不同消息解析规则进行抽象
 * <br/>
 * Date:     2015年6月24日 上午10:38:57 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface PareDataRule {
	
	 /**
	  * 
	  * pareString2Object:(这里用一句话描述这个方法的作用). <br/>
	  * @author  xxg
	  * @param pareDate ，解析数据中每一条记录以字符串形式抽象
	  * @param T  ，要转换的类型
	  * @return 返回数据源每一条数据对象，因为目前我们的消息格式是固定的，如果以后扩展，
	  * 可以动态扩展，只要重新实现解析规则对象即可
	  * @since JDK 1.7
	  */
	 public  <T>  T  pareString2Object(String pareDate,T t);
	

}

