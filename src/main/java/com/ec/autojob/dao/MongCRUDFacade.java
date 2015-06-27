package com.ec.autojob.dao;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * 
 * ClassName: MongCRUDFacade <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年6月25日 下午10:05:13 <br/>
 *
 * @author xxg
 * @version 
 * @since JDK 1.7
 */
public interface MongCRUDFacade {
	 
	  public FindIterable<Document> find();
	  
	  public FindIterable<Document> findByBson(Bson filter);
	  
	  public void insertOne(Document document);
	  
	  public void insertMany(List<Document> documents);
	  
	  public DeleteResult	deleteOne(Bson filter);
	  
	  public DeleteResult	deleteMany(Bson filter);
	  
	  public UpdateResult updateOne(Bson filter,Bson update);
	  
	  public UpdateResult updateMany(Bson filter,Bson update);
	

}
