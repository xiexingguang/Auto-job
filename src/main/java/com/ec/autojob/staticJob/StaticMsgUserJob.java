/**
 * Project Name:autoJob
 * File Name:StaticMsgUserJob.java
 * Package Name:com.ec.autojob.staticJob
 * Date:2015年6月25日下午7:03:30
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/
package com.ec.autojob.staticJob;
import com.ec.autojob.bean.StaticUserResultBean;
import com.ec.autojob.service.StaticMsgService;
import com.ec.autojob.serviceImp.StaticMsgUserServiceImpl;
import com.ec.autojob.staticJob.core.AbstractStaticMsgJob;

/**
 * ClassName:StaticMsgUserJob <br/>
 * Function
 * 统计每日EIM活跃用户job类
 * <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月25日 下午7:03:30 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class StaticMsgUserJob<T>  extends AbstractStaticMsgJob<T>{
    
	private StaticMsgService staticService;
	/**
	 * 
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.ec.autojob.staticJob.core.AbstractStaticMsgJob#getStaticMsgService()
	 */
	protected  synchronized StaticMsgService getStaticMsgService(){
		  if(staticService == null){
			  staticService = new StaticMsgUserServiceImpl();
			  return staticService;
		  }
		  return staticService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected T handleStaticTask(String collectionName) {
		StaticUserResultBean t = getStaticMsgService().handlerStaticData(collectionName, new StaticUserResultBean());
		return  (T)t;
	}

}

