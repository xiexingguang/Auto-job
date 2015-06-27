/**
 * Project Name:autoJob
 * File Name:ReflectUtil.java
 * Package Name:com.ec.autojob.util
 * Date:2015年6月25日下午8:18:28
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/

package com.ec.autojob.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.springframework.expression.spel.ast.TypeReference;

import com.ec.autojob.bean.StaticUserResultBean;
import com.ec.autojob.staticJob.StaticMsgSumJob;



/**
 * ClassName:ReflectUtil <br/>
 * Function: 
 * 
 * 反射工具类<br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年6月25日 下午8:18:28 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class ReflectUtil {
	
	 static class A<T> {
	        T t;
	 
	        public void test() {
	            System.out.println(t);
	        }
	    }
	 
	    static class B<T> {
	        T t;
	        public B(T t) {this.t = t;}
	 
	        public void test() {System.out.println(t);}
	    }
	 
	    public static void main(String[] args) throws Throwable {
	        /*Class<?> c = A.class;
	        Object o = c.newInstance();
	        Method m = c.getDeclaredMethod("test");
	        m.invoke(o);
	         
	        c = B.class;
	        Constructor con = c.getDeclaredConstructor(new Class[]{Object.class}); //用Object.class代替T
	        o = con.newInstance(new Object[]{"bbb"});
	        m = c.getDeclaredMethod("test");
	        m.invoke(o);
	        
	        StaticMsgSumJob<StaticUserResultBean> g = new StaticMsgSumJob<StaticUserResultBean>();
	        */
	       
}
}
