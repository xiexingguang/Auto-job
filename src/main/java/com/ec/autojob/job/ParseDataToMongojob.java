package com.ec.autojob.job;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.bson.Document;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
/**
 * 解析文件，并插入到mongodb中，程序要保证日志文件的完整性,
 * 保证日记的kw级别的数据先入库mongodb库中 
 * @author jasshine_xxg
 *
 */
public class ParseDataToMongojob implements Job{

    
	@SuppressWarnings("rawtypes")
	private MongoCollection  c = getConnection();
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//MongoCollection c = getConnection();
		//1.首先到相应的目录上去读日志文件
		//2。然后解析拼接字符串串
		//3.将拼接的插入到mongodb中去。其中要考虑插入失败，怎么办，解析失败怎么办》》？？各种异常处理
		 System.out.println("开始解析文件======================》");
		 long beginTime = System.currentTimeMillis();
		 FileInputStream in = null;
		 BufferedReader br = null;
	  try{   
		 in = new FileInputStream("G://msg20150622/msg20150622.log1");
		 br = new BufferedReader(new InputStreamReader(in));
		 String s1 = "";
		 while((s1=br.readLine())!=null){
			 System.out.println("日志记录为==>"+s1);
			 //解析日志，一条条解析
			 String[] ss = s1.split("\\|\\|");
			 if(ss == null || ss.length !=7){
				 throw new RuntimeException("解析的字符有问题，解析失败");
			 }
			 Document d = new Document();
			 d.append("sdtm", ss[0]);
			 d.append("resource", ss[1]);
			 d.append("dest", ss[2]);
			 d.append("type", ss[3]);
			 d.append("cropid", ss[4]);
			 d.append("zdtype", ss[5]);
			 d.append("module", ss[6]);
			 c.insertOne(d);
			 
			 //插入mongodb(出现例外怎么处理)
			 System.out.println(s1);
		 }//end while
		
		 System.out.println("经历耗费时间为=========》"+(System.currentTimeMillis()-beginTime));
	  }catch(Exception e){
		  e.printStackTrace();
	  }finally{
		  try{
			  br.close();
			  in.close();
		  }catch(Exception e){
			  br = null;
			  in = null;
		  }
	  }
		
	}
   
	private MongoCollection getConnection(){
		MongoClient client = new MongoClient("192.168.81.128", 30000);
		return client.getDatabase("fristdb").getCollection("staticmsg");
		
	}
	
	
}
