/**
 * Project Name:autoJob
 * File Name:MongoProperties.java
 * Package Name:com.ec.autojob.properties
 * Date:2015年6月25日下午8:50:19
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName:MongoProperties <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月25日 下午8:50:19 <br/>
 * @author   ecuser
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public class MongoProperties {
	@Value("${production.mongos.host}")
	public   String MONGOS_HOSTS;
	@Value("${production.mongos.host.dataBase}")
	public   String MONGO_DATABASE;
	@Value("${mongo.connectionsPerHost}")
	public    String  MONGO_CONNECT;
	@Value( "${mongo.threadsAllowedToBlockForConnectionMultiplier}")
	public   String  MONGO_THREADCM;
	@Value( "${mongo.connectTimeout}")
	public    String  MONGO_TIEMOUT;
	@Value( "${mongo.maxWaitTime}")
	public   String  MONGO_MAXWAITE_TIME;
	@Value( "${mongo.socketTimeout}")
    public   String  MONGO_SOCKETIMEOUT;
	@Value( "${configOptions}")
    public   String  MONOG_CONFIGOPTION;
}

