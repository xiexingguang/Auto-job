/**
 * Project Name:autoJob
 * File Name:FileCollectMsgJob.java
 * Package Name:com.ec.autojob.collectJob
 * Date:2015年6月24日下午5:20:55
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.collectJob;

import com.ec.autojob.collectJob.core.AbstractCollectMsgJob;
import com.ec.autojob.collectJob.core.CollectMsgInterface;

/**
 * ClassName:FileCollectMsgJob <br/>
 * Function: 数据源为日志文件job类 <br/>
   <br/>
 * Date:     2015年6月24日 下午5:20:55 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class FileCollectMsgJob extends AbstractCollectMsgJob{
    
	private CollectMsgInterface collectMsg;
	@Override
	protected CollectMsgInterface getCollectMsg() {
		    if(collectMsg == null){
		    	collectMsg = new  CollectMsgFromFileLog();
		    	return collectMsg;
		    }
		    return collectMsg;
	}

}

