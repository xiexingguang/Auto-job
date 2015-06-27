/**
 * Project Name:autoJob
 * File Name:StaticMsgSum.java
 * Package Name:com.ec.autojob.basedaoTest
 * Date:2015年6月26日下午9:06:06
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.basedaoTest;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ec.autojob.daoImpl.StaticMsgSumDaoImpl;

/**
 * ClassName:StaticMsgSum <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月26日 下午9:06:06 <br/>
 * @author   ecuser
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class StaticMsgSum {
   
	private StaticMsgSumDaoImpl dao;
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
		System.out.println("begin");
		dao = new StaticMsgSumDaoImpl("msg");
		System.out.println(dao.getCollection());
	}
  
	
	
}

