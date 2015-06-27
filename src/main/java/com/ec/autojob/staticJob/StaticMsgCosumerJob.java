/**
 * Project Name:autoJob
 * File Name:StaticMsgCosumerJob.java
 * Package Name:com.ec.autojob.staticJob
 * Date:2015年6月25日下午7:03:53
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/
package com.ec.autojob.staticJob;
import com.ec.autojob.bean.StaticCustResultBean;
import com.ec.autojob.service.StaticMsgService;
import com.ec.autojob.serviceImp.StaticMsgConsumerSeviceImpl;
import com.ec.autojob.staticJob.core.AbstractStaticMsgJob;

/**
 * ClassName:StaticMsgCosumerJob <br/>
 * Function: 统计网站客服活跃用户统计<br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月25日 下午7:03:53 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class StaticMsgCosumerJob<T> extends AbstractStaticMsgJob<T>{
	
	private StaticMsgService staticService;
	
   /**
    * 
    * TODO  统计消息总量的service（可选）.
    * @see com.ec.autojob.staticJob.core.AbstractStaticMsgJob#getStaticMsgService()
    */
	protected  synchronized StaticMsgService getStaticMsgService(){
		  if(staticService == null){
			  staticService = new StaticMsgConsumerSeviceImpl();
			  return staticService;
		  }
		  return staticService;
	}
   
	// 统计引擎，需要service辅助
	@Override
	protected T handleStaticTask(String collectionName) {
		@SuppressWarnings("unchecked")
		T  t = (T)staticService.handlerStaticData(collectionName, new StaticCustResultBean());
		return t;
	}



}

