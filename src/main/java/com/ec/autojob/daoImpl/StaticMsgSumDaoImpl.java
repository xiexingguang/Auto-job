/**
 * Project Name:autoJob
 * File Name:StaticMsgSumDaoImpl.java
 * Package Name:com.ec.autojob.daoImpl
 * Date:2015年6月26日下午6:00:23
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.daoImpl;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

/**
 * ClassName:StaticMsgSumDaoImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月26日 下午6:00:23 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class StaticMsgSumDaoImpl extends BaseRepository{
    
	
	public String collectName;
	public StaticMsgSumDaoImpl(String name){
		this.collectName = name;
	} 
	
	@Override
	public  MongoCollection<Document> getCollection() {
		return getMongoDataBase().getCollection(collectName);
		
	}

	
	
}

