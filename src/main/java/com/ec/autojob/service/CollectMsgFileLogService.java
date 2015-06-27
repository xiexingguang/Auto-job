/**
 * Project Name:autoJob
 * File Name:CollectMsgService.java
 * Package Name:com.ec.autojob.service
 * Date:2015年6月24日下午1:53:55
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.service;

import java.io.File;

/**
 * ClassName:CollectMsgService <br/>
 * Function: 
 * 处理数据源为从日志文件过来的
 * 的service 类
 * Date:     2015年6月24日 下午1:53:55 <br/>
 * @author   ecuser
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface CollectMsgFileLogService {
	    
	     /**
	      * 
	      * collectMsgFromSingleFile:(收集单个文件api,要暴露给远端调用). <br/>
	      * @author xxg
	      * @param filepath
	      * @since JDK 1.7
	      */
        public  void  collectMsgFromSingleFile(String  filepath);
	
        /**
         * 
         * collectMsgFromSingleFileByFile:(解析文件，如果该文件是目录，则收集目下的文件数据，如果是文件，
         * 则单独收集该文件的数据). <br/>
         * @author xxg
         * @param file
         * @since JDK 1.7
         */
        public  void collectMsgFromFile(File file);
        
 
}

