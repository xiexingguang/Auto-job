package com.ec.autojob.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 利用mapreduce 统计数据
 * 从mongodb中取出数据，进行统计，将统计结果插入到
 * mysql数据库
 * @author jasshine_xxg
 *
 */
public class StatisMsgDataJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}

}
