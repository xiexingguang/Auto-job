package com.ec.autojob.app;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ec.autojob.job.ParseDataToMongojob;

/**
 * 
 * @author jasshine_xxg
 *
 */
public class AutoJobEntry extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext arg0)throws JobExecutionException {
		 System.out.println("job is  begin...........");
		 Job j = new ParseDataToMongojob();                              
		 j.execute(arg0);//要等job执行完，才会
	}

}
