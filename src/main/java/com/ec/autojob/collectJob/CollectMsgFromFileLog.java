/**
 * Project Name:autoJob
 * File Name:CollectMsgFromFile.java
 * Package Name:com.ec.autojob.collectJob
 * Date:2015年6月24日上午11:54:10
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.collectJob;
import java.io.File;
import java.io.FilenameFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ec.autojob.collectJob.core.CollectMsgInterface;
import com.ec.autojob.common.MsgConstants;
import com.ec.autojob.properties.ConfigProperties;
import com.ec.autojob.service.CollectMsgFileLogService;
import com.ec.autojob.serviceImp.CollectMsgServiceImpl;
import com.ec.autojob.util.LogUtil;

/**
 * ClassName:CollectMsgFromFile <br/>
 * Function: 从文件中解析日志. 
 * 数据来源从文件中获得，
 * <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月24日 上午11:54:10 <br/>
 * @author  xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public  class  CollectMsgFromFileLog  implements  CollectMsgInterface {
	
	
	private static final Logger  LOG = LogManager.getLogger("collectMsgFromFileLog");
    private static final String  LOG_FILE_DIR= ConfigProperties.MSG_LOG_DIR; //工具类获得单天的日志名称，日志命名规则要一致

    public  CollectMsgFileLogService  msgService;
    
    /**
     * 
     * TODO  收集日志业务逻辑处理类（可选）.
     * @see com.ec.autojob.collectJob.core.CollectMsgInterface#collectMsg()
     */
	@Override
	public void collectMsg() {
		    // 生成当天搜索文件名称,模糊搜索匹配当天的所有日志
		     final  String dir = LOG_FILE_DIR +File.separator ; //搜索日志消息所在目录
		     final  String pattern = dir +MsgConstants.LOG_NAME_PROFIX+LogUtil.generatePareLogFileDir(); //匹配条件
		     File file  = new File(dir);
		     if(!file.exists()){
		    	 LOG.debug("不存在该目录"+dir);
		    	 return ;
		     }
		     if(!file.isDirectory()){
		    	 LOG.debug("该路径不是以个目录"+dir);
		    	 return ;
		     }
		     
		     //根据搜索pattern 寻找符合条件的日志文件进行解析
		     File[] files = file.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
				    if(name.startsWith(pattern))
					return true;
				    else  return false;
				}
			});
		     
		    for(File ff  : files){
		    	if(LOG.isDebugEnabled()){
		    		LOG.debug("当天要统计的日志分为=======》"+ff.getName());
		    	}
		        getMsgService().collectMsgFromFile(ff); //不处理file为null异常，其他异常处理掉了
		    }
	}
	
	/**
	 * 
	 * getMsgService:这个service 是专门解析数据源为file的，
	 * 
	 *  如果要实现不同逻辑可以覆盖这个方法，实现自己的
	 *  处理规则。
	 *  <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * @author xxg
	 * @return
	 * @since JDK 1.7
	 */
	protected  synchronized CollectMsgFileLogService getMsgService(){
		   if(msgService == null){
			   msgService = new CollectMsgServiceImpl();
			   return msgService;
		   }
		   return msgService;
	}
		  
}

