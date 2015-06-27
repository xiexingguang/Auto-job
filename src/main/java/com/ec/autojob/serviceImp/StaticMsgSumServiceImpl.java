/**
 * Project Name:autoJob
 * File Name:StaticMsgSumServiceImpl.java
 * Package Name:com.ec.autojob.serviceImp
 * Date:2015年6月25日下午3:41:01
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/
package com.ec.autojob.serviceImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import com.ec.autojob.daoImpl.StaticMsgSumDaoImpl;
import com.ec.autojob.service.StaticMsgService;
import com.mongodb.client.MongoCollection;

/**
 * ClassName:StaticMsgSumServiceImpl <br/>
 * Function: 统计消息发送总量，
 * 因为要提供rmi暴露接口，所以一个业务统计
 * 一个service，方便通过api方式手工调用
 *  <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月25日 下午3:41:01 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class StaticMsgSumServiceImpl implements StaticMsgService {
	
	
	private static final Logger LOG = LogManager.getLogger("");
	private StaticMsgSumDaoImpl staticMsgSum;
    
	
	@Override
	public <T> T handlerStaticData(String colletcionName, T t) {
	    staticMsgSum = new StaticMsgSumDaoImpl(colletcionName);
	    MongoCollection<Document>  collection = staticMsgSum.getCollection();
	   
	    //统计PC客户端发送量（EIM）
	   // staticMsgSum.findByBson(filter)
	    
	    
	    
		return null;
	}
  

}

