package com.ec.autojob.common;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ec.autojob.properties.MongoProperties;
import com.mongodb.MongoClientOptions;

/**
 * 
 * ClassName: MongodbConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年6月25日 下午8:55:57 <br/>
 *
 * @author xxg
 * @version 
 * @since JDK 1.7
 */
@Component
public class MongodbConfig {
	
	@Autowired
	public MongoProperties proMongo;
	public  MongoClientOptions options ;
	
	@PostConstruct
	public void init(){
		try{	
			 final int connet_host = Integer.parseInt(proMongo.MONGO_CONNECT);
			 final int thread_allow_to = Integer.parseInt(proMongo.MONGO_THREADCM);
			 final int conn_time_out = Integer.parseInt(proMongo.MONGO_TIEMOUT);
			 final int max_wait_time_out = Integer.parseInt(proMongo.MONGO_MAXWAITE_TIME);
			 final int scoket_out = Integer.parseInt(proMongo.MONGO_SOCKETIMEOUT);
			 
			 MongoClientOptions.Builder  builder	 = new MongoClientOptions.Builder();
			 builder.connectionsPerHost(connet_host);
			 builder.connectTimeout(conn_time_out);
			 builder.maxWaitTime(max_wait_time_out);
			 builder.socketTimeout(scoket_out);
			 builder.threadsAllowedToBlockForConnectionMultiplier(thread_allow_to);
			 options = builder.build();
			 
		}catch(Exception e){
			 throw  new RuntimeException("加载mongdb自定义配置文件失败，异常信息为==>"+e.toString());
		}
			 
	}
	
	
	/**
	 * 获取
	 * @return
	 */
	public  MongoClientOptions getClientOptions(){
	     
		 return options;
	}
	

}
