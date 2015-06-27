/**
 * Project Name:autoJob
 * File Name:PareString2StirngArray.java
 * Package Name:com.ec.autojob.collectJob
 * Date:2015年6月24日上午10:42:48
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.collectJob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ec.autojob.collectJob.core.PareDataRule;
import com.ec.autojob.common.exception.ConvertString2beanException;
import com.ec.autojob.util.StringUtil;

/**
 * ClassName:PareString2StirngArray <br/>
 * Function:将单条消息记录转换成javabean对象。  <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月24日 上午10:42:48 <br/>
 * @author   ecuser
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public  class PareString2MsgBean  implements PareDataRule{
    
	private  String  default_fixString = "\\|\\|";
	private static  final Logger   LOG = LogManager.getLogger("collectjobLog");
	
	
	@Override
	public <T> T pareString2Object(String pareDate,T t) {
		
	try{	 
			 if(LOG.isDebugEnabled()){
				 LOG.debug("待解析的记录为=======>"+pareDate);
			 }
			 String regex = getSeparator();
			 //2014-05-15 14:24:31||2||764536||2||13412345432||13098765432||1||2
			 String[] arraysStrings = pareDate.split(regex); 
			 T  msgBean = StringUtil.convertStringArray2Object(arraysStrings,t); 
			 return msgBean;
		}catch(Exception e){
			 throw new ConvertString2beanException("转换bean出现异常",e);
		}
		
	}
	 //分隔符，子类可以继承该类，设定自己的日志分隔方式，目前默认为|| 方式分隔
	 public  String  getSeparator(){
		          return default_fixString;
	 }
}

