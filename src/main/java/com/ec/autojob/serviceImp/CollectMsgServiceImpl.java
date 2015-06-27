/**
 * Project Name:autoJob
 * File Name:CollectMsgServiceImpl.java
 * Package Name:com.ec.autojob.serviceImp
 * Date:2015年6月24日下午1:54:47
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.serviceImp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ec.autojob.bean.LogMsgBean;
import com.ec.autojob.collectJob.ConvertString2beanExceptionHandler;
import com.ec.autojob.collectJob.PareString2MsgBean;
import com.ec.autojob.collectJob.core.CollectMsgExceptionHandler;
import com.ec.autojob.collectJob.core.PareDataRule;
import com.ec.autojob.common.MongoMsgResultHandle;
import com.ec.autojob.common.MsgResultHandle;
import com.ec.autojob.common.exception.ConvertString2beanException;
import com.ec.autojob.common.exception.PareFileException;
import com.ec.autojob.service.CollectMsgFileLogService;

/**
 * ClassName:CollectMsgServiceImpl <br/>
 * Function:  <br/>
 * Reason:	. <br/>
 * Date:     2015年6月24日 下午1:54:47 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class CollectMsgServiceImpl  implements CollectMsgFileLogService{
    
	private static final Logger LOG = LogManager.getLogger("collectMsgServiceLOG");
	
	/**
	 * 数据解析规类，将待转换的字符，根据指定解析规则，解析成对应的javabean对象
	 */
	private PareDataRule pdrule;
	
	/**
	 * 消息结果出来策略，针对单条记录处理策略，有可能是入mysql库，可能入mogodb库，等。。。
	 */
	private MsgResultHandle msgHandle;
	
	
	private  static  HashMap< RuntimeException,CollectMsgExceptionHandler> EXCEPTION_HANDLER = new HashMap<RuntimeException, CollectMsgExceptionHandler>();
	
	static{
		EXCEPTION_HANDLER.put(new ConvertString2beanException(), new ConvertString2beanExceptionHandler());
	}
	
	@Override
	public void collectMsgFromSingleFile(String filepath) {
		     File  file  = new File(filepath);
		     if(!file.isFile()){ 
		    	  throw new IllegalArgumentException("路径为["+filepath+"]不是一个文件");
		     }
		     FileReader fReader = null;
		     BufferedReader bufferedReader = null;
		     String str = "";
		     PareDataRule prule = null;
		     try {
			     fReader = new FileReader(file);
			     bufferedReader = new BufferedReader(fReader);
			     prule = getpDataRule(); //可扩展自己需要的解析规则
			     while((str = bufferedReader.readLine())!=null){
			    	 if(LOG.isDebugEnabled()){
			    		 LOG.debug("单条消息日志记录为====="+str);
			    	 }
			    	 LogMsgBean logBean = prule.pareString2Object(str,new LogMsgBean()); //将日志记录转换成javaBean
			    	 msgHandle.handleMsgBean(logBean);
			     }//end while
			     
		     }catch(IOException e){
		    	   LOG.error("异常消息日志记录为["+str+"]异常信息为===》"+e.toString()+"出现异常文件为======》"+file.getAbsolutePath());
		    	   throw new PareFileException("解析文件出现IO异常", e);
		    }catch (ConvertString2beanException e) { //出现在解析日志消息出现异常时
		    	 LOG.error("异常消息日志记录为["+str+"]异常信息为===》"+e.toString()+"出现异常文件为======》"+file.getAbsolutePath());
		    	 CollectMsgExceptionHandler  hander = EXCEPTION_HANDLER.get(e);
		    	 hander.handlerException(str);
			}finally{
				      if(fReader  != null){
							  try {
								fReader.close();
							} catch (IOException e) {
								fReader = null;
								
							}
				      }
				      if(bufferedReader != null){
							  try {
								bufferedReader.close();
							} catch (IOException e) {
							    bufferedReader = null;
							}
				      }
			}//end finally
	}
	 
	/**
	 * 
	 * getpDataRule:日志解析规则，子类如果希望可以继承重写. <br/>
	 * @author xxg
	 * @return
	 * @since JDK 1.7
	 */
	  protected  synchronized PareDataRule getpDataRule(){
		    if(pdrule == null){
		    	pdrule = new PareString2MsgBean();
		    	return pdrule;
		    }
		   return pdrule; 
	  }
	  
	  /**
	   * 
	   * getMsgResultHandle:日志数据结果处理，子类可以重写该方法，默认为
	   * 将数据插入到mongodb中<br/>
	   * @author xxg
	   * @return
	   * @since JDK 1.7
	   */
	  protected  synchronized MsgResultHandle getMsgResultHandle(){
		    if(msgHandle == null){
		    	msgHandle = new MongoMsgResultHandle();
		    	return msgHandle;
		    }
		    return msgHandle;
	  }

	@Override
	public void collectMsgFromFile(File file) {
		  
		 if(file == null || !file.exists()){
			 throw new NullPointerException("要解析的目录不存在或者为null");
		 }
	      if(file.isDirectory()){
	    	   File[] files = file.listFiles();
	    	   for(File f : files){
	    		   if(LOG.isDebugEnabled()){
	    			   LOG.debug("单个文件名称为===》"+f.getName() +"<===========单个日志文件路径为====》"+f.getAbsolutePath());
	    		   }
	    		   collectMsgFromSingleFileByFiles(f);   //统计数据，循环调用这样可能导致持续时间很长，这个方法会阻塞？优化？多线程？？先这样，如果有性能问题重写该方法
	    	   }
	      }	else{
	           collectMsgFromSingleFileByFiles(file);
	      }
	}

	
	// 收集单个文件数据
	/**
	 * 
	 * collectMsgFromSingleFileByFiles:(这里用一句话描述这个方法的作用). <br/>
	 * @author ecuser
	 * @param file
	 * @since JDK 1.7
	 * @throws PareFileException :当文件解析的时候出现IO异常，这个时候异常处理不了，必须抛出
	 */
	private void collectMsgFromSingleFileByFiles(File file) {
		
		 if(file == null){
			 throw new NullPointerException("传入文件为null");
		 }
		
		 if(!file.exists()){
			 if(LOG.isDebugEnabled()){
				  LOG.debug("单个文件绝对路径为"+file.getAbsolutePath()+"===名称为"+file.getName());
			 }
			 throw new RuntimeException("文件不存在"+file.getName());
		 }
		 
		 if(file.isDirectory()){
			 throw new RuntimeException("解析失败，该文件为一个目录，目录路径为"+file.getAbsolutePath());
		 }
		
		     FileReader fReader = null;
		     BufferedReader bufferedReader = null;
		     String str = "";
		     PareDataRule prule = null;
		     
		    try {
			     fReader = new FileReader(file);
			     bufferedReader = new BufferedReader(fReader);
			     prule = getpDataRule(); //可扩展自己需要的解析规则
			     while((str = bufferedReader.readLine()) != null){
			    	 if(LOG.isDebugEnabled()){
			    		 LOG.debug("单条消息日志记录为====="+str);
			    	 }
			    	 LogMsgBean logBean = prule.pareString2Object(str,new LogMsgBean()); //将日志记录转换成javaBean
			    	 msgHandle.handleMsgBean(logBean);
			     }//end while
			     
		     }catch(IOException e){
		    	   LOG.error("异常消息日志记录为["+str+"]异常信息为===》"+e.toString()+"出现异常文件为======》"+file.getAbsolutePath());
		    	   throw new PareFileException("解析文件出现IO异常", e);
		    }catch (ConvertString2beanException e) { //出现在解析日志消息出现异常时
		    	 LOG.error("异常消息日志记录为["+str+"]异常信息为===》"+e.toString()+"出现异常文件为======》"+file.getAbsolutePath());
		    	 CollectMsgExceptionHandler  hander = EXCEPTION_HANDLER.get(e);
		    	 hander.handlerException(str);
			}finally{
				      if(fReader  != null){
						  try {
							fReader.close();
						} catch (IOException e) {
							fReader = null;
							
						}
				      }
				      if(bufferedReader != null){
						  try {
							bufferedReader.close();
						} catch (IOException e) {
						    bufferedReader = null;
						}
				      }
			}//end finally
	}
}

