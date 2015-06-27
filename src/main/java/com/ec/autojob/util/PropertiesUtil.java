/* **************************************************************
*
* 文件名称：PropertiesUtil.java
*
* 包含类名：com.cloudpower.util.PropertiesUtil
* 创建日期：2013-3-29
* 创建作者：zhoujintang
* 版权声明：Copyright 2013 大唐云动力科技股份有限公司 保留所有权利。
*
* **************************************************************/
package com.ec.autojob.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



/**

 * 属性文件读取工具类

 * <类功能详细描述>

 * 创建日期：2013-3-29

 * 创建作者：zhoujintang

 *

 * 修改日期：2013-3-29

 * 修改人员：zhoujintang

 * 修改内容：<修改内容>

 */
public class PropertiesUtil {
	private static Properties properties=new Properties();
	
	private static Document taskDoc;//自动任务定义
	
	static{
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		// 获得配置文件
		InputStream is = cl.getResourceAsStream("/config.properties");
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
    public static String get(String key){
    	Object object=properties.get(key);
    	if(object==null){
    		return null;
    	}else{
    		return object.toString();
    	}
    }
    
    public static Element getTaskElement(String id) throws Exception{
		if(taskDoc==null){
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			// 获得配置文件
			InputStream is = cl.getResourceAsStream("/task.xml");
			SAXReader saxReader = new SAXReader();
			taskDoc = saxReader.read(is);
		}
		@SuppressWarnings("rawtypes")
		List listTask = taskDoc.selectNodes("/tasks/task");
		for(Object o : listTask){
			Element task = (Element)o;
			if(id.equals(task.attributeValue("id"))){
				return task;
			}
		}
		return null;
	}
    
}
