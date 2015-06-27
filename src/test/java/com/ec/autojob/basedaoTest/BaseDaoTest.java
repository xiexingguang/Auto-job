package com.ec.autojob.basedaoTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext.xml"})
public class BaseDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private JdbcTemplate jdbpcTemplate;
	
	@Test
	public void testInsert(){
		System.out.println(jdbpcTemplate);
		
       String sql = "insert into user values(1,\"xxg\",14)";
       jdbpcTemplate.execute(sql);
      // jdbpcTemplate.e
      
	}
	
	@Test
	public void testQuery(){
	/*	String sql = "select *from user";
		jdbpcTemplate.query(sql, new rowmap)*/
		//jdbpcTemplate.up
	}
	 

}
