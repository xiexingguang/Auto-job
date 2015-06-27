package com.ec.autojob.basedaoTest;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

public class MongoTest {
	
	
	  public static void main(String[] args) {
		  MongoClient client = new MongoClient("192.168.81.128", 30000);
		  MongoCollection c = client.getDatabase("fristdb").getCollection("staticmsg");
		  Document d = new Document();
		  
		 // d.append("name", "xxg");
		  c.insertOne(d);
	}

}
