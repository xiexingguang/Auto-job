/**
 * Project Name:autoJob
 * File Name:ConfigProperties.java
 * Package Name:com.ec.autojob.properties
 * Date:2015年6月24日下午8:40:00
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName:ConfigProperties <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月24日 下午8:40:00 <br/>
 * @author   ecuser
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public class ConfigProperties {
     
	 @Value("${msglog.dirpath}")
	 public static  String  MSG_LOG_DIR;  // 消息日志存放目录
	
	 @Value("${errlog.dirpath}")
	 public static String  ERROR_MSG_LOG_DIR; //处理有问题的日志消息存放目录
	
}

