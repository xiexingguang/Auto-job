/**
 * Project Name:autoJob
 * File Name:DefaultStaticMsgListener.java
 * Package Name:com.ec.autojob.staticJob
 * Date:2015年6月25日下午2:48:41
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.staticJob.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * ClassName:DefaultStaticMsgListener <br/>
 * Function: 监听器，在数据统计完成或者之前添加业务逻辑<br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月25日 下午2:48:41 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class DefaultStaticMsgListener  implements StaticMsgListener{
    
	private static final Logger LOG = LogManager.getLogger("");
	
	//还要依赖操作mysql 的service层 
	
	@Override
	public void before() {
	
	}

  
	@Override
	public void handleException(Throwable t) {  // 处理异常
		
		// TODO Auto-generated method stub 
		
	}

   // 默认的监听器，数据统计完后会将统计bean插入到mysql库中
	@Override
	public <T> void after(T t) {
		
		// TODO Auto-generated method stub
		
	}

}

