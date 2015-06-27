/**
 * Project Name:autoJob
 * File Name:LogUtil.java
 * Package Name:com.ec.autojob.util
 * Date:2015年6月24日下午8:15:37
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ec.autojob.common.MsgConstants;

/**
 * ClassName:LogUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月24日 下午8:15:37 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class LogUtil {
      
	  
	 /**
	  * 
	  * //根据当天的日期算出前一天的日期，因为我们自动任务跑的都是跑前一天的文件，
	 // 前一天的消息日志我们放在20150629 <br/>
       
	  * @author xxg 
	  * @return  如果当前日期是20150630，则返回20150629 
	  * @since JDK 1.7
	  */
	  public static String  generatePareLogFileDir(){
		  Date date = new Date();
		  Date  dBefore = new Date();
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(date);
		  calendar.add(Calendar.DAY_OF_MONTH, -1);
		  dBefore = calendar.getTime();
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
		  String defaultStartDate = sdf.format(dBefore);    //格式化前一天
          return defaultStartDate;
	  }
	  
	  public static void main(String[] args) {
		System.out.println(generatePareLogFileDir());
	}
	
	
	  
}

