/**
 * Project Name:autoJob
 * File Name:StringUtil.java
 * Package Name:com.ec.autojob.util
 * Date:2015年6月24日上午11:22:23
 * Copyright (c) 2015, 深圳市六度人和 All Rights Reserved.
 *
*/
package com.ec.autojob.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.ec.autojob.common.exception.AayLengthNotEqObFileNumsException;
import com.ec.autojob.common.exception.CallReflectSetException;
import com.ec.autojob.common.exception.WriteStringToLogException;

/**
 * ClassName:StringUtil <br/>
 * Function: 
 * 字符串工具类
 *  
 *  <br/>
 * Date:     2015年6月24日 上午11:22:23 <br/>
 * @author   xxg
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class StringUtil {
	
	
	/**
	 * 
	 * convertStringArray2Object:(将字符数组里面的值映射成javabean对象).
	 * 
	 *  <br/>
	 * @param arrays
	 * @param 
	 * @return
	 * @throws AayLengthNotEqObFileNumsException 数组长度跟bean数量不一致出现异常
	 * @throws CallReflectSetException   反射调用set** 方法出现异常。
	 * @throws 其他异常
	 * @since JDK 1.7
	 */
	public  static <T>  T  convertStringArray2Object(String[] arrays,T t){
		
			  @SuppressWarnings("rawtypes")
			   Class  tclass = t.getClass();
			   Field[] fields = tclass.getFields(); //得到该类的所有域
			   
			   if(fields.length != arrays.length){
				   throw new AayLengthNotEqObFileNumsException("数组长跟根实体bean长度不一致，转换失败");//自定义异常
			   }
			   try{
				   for(int i = 0 ; i < arrays.length ; i++){
						 String fieldName = fields[i].getName();
						 String methodName = "set"+toUpperFildeName(fieldName);
						 @SuppressWarnings("unchecked")
						 Method m = tclass.getMethod(methodName, fields[i].getType());
						 m.invoke(t, arrays[i]);
				   }
			   }catch(Exception e){
				       throw new CallReflectSetException("call set 方法出现异常", e);
			   }
		   return t;
	}
	
	private static String toUpperFildeName(String fileName){
		 String fristChar = fileName.substring(0, 1).toUpperCase();
		 String newS = fristChar + fileName.substring(1, fileName.length());
		 return newS;
	}
	
	
	/**
	 * 
	 * writeString2File:将记录一行行写入到文件中去. <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * @author xxg
	 * @param filepath，文件完整路径，包括文件名 d://xxg/yyy/1.txt
	 * @throws WriteStringToLogException 
	 * @since JDK 1.7
	 */
	public  static void writeString2File(String filepath,String msg){
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try{
			  File  file = new File(filepath);
			  if(!file.exists()){
				  String parentFliePath = file.getParent();
				  File  parenFile = new File(parentFliePath);
				  if(parenFile.mkdirs()){
					  file.createNewFile();
				  }//end if
			  }//end if
			  fw = new FileWriter(file,true);
		  	  bw = new BufferedWriter(fw);
		  	  bw.write(msg+"\n\r");
		}catch(Exception e){
			  throw new WriteStringToLogException("写入数据到文件异常", e);
		}finally{
				 if(bw!=null){
					   try {
							bw.close();
						} catch (IOException e) {
						    bw = null;
						}
				 }
				 if(fw!=null){
					   try {
						fw.close();
					} catch (IOException e) {
					    fw = null;
					}
				 }
		}
	}
      public static void main(String[] args) throws IOException {
		/*   File file = new File("d:/wewe/xxg/ee.txt");
		 //  System.out.println(file.isDirectory());
		   String s = file.getParent();
		   System.out.println(s);
		   
		   File parentFI = new File(s);
		   System.out.println(parentFI.mkdirs());
		   System.out.println(file.exists()); //如果文件不存在，则创建新文件
		   file.createNewFile();*/
    	  
    	  //writeString2File("d:/xxg/2.txt","i love you");
    	  File f = new File("d://xxg");
    	  
    	  File[]  fs = f.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
                if(name.startsWith("immsg-2015-05-03"))
				return true;
                else return false;
			}
		});
    	  System.out.println(f.isFile());
    	  System.out.println(f.exists());
         for(File ff:fs){
        	  System.out.println(ff.getName());
         }
	} 
}

