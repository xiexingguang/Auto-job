package com.ec.autojob.collectJob.core;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
/**
 * ClassName:CollectMsgJob <br/>
 * Function: 收集消息job类
 * 抽象job类，该execute是一个模板方法
 *子类继承它，实现自己的消息收集，
 * 目前项目中我们使用的收集数据源为文件 
 *
 * <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月24日 上午11:32:27 <br/>
 * @author   ecuser
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public abstract class AbstractCollectMsgJob implements Job {
	
	private static final Logger  LOG = LogManager.getLogger("collectMsgJobLog");
  
	protected abstract CollectMsgInterface  getCollectMsg();
    
    
	@Override
	public void execute(JobExecutionContext arg0) {
		  if(LOG.isDebugEnabled()){
			  LOG.debug(">>>>>>>>>>>>>>>收集消息日志数据job开始执行>>>>>>>>>>>>");
		  }
		  long  beginTime = System.currentTimeMillis();
		  //解析数据(从文件中解析数据来源)
		  //插入数据
		
		   getCollectMsg().collectMsg(); //收集数据
	
		   if(LOG.isDebugEnabled()){
				  LOG.debug(">>>>>>>>>>>>>>>收集消息日志数据job结束话费时间为===》"+(System.currentTimeMillis()-beginTime));
		  }
	}
   
}

