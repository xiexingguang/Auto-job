package com.ec.autojob.basedaoTest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ParseData {
	
	 public static void main(String[] args) throws IOException {
		String dataPath = "G://msg20150622/msg20150622.log1";
		pareOneFile(dataPath);
		/*String p = "2014-05-15 14:24:31||2||764536||13412345432||13098765432||1||2";
		String[] pp = p.split("\\|\\|");
		System.out.println(pp.length);
		for(String s : pp){
			System.out.println(s);
		}*/
	}
	 
	 //500w条数据 5分钟，左右，用spilt去解析，其中不包括插入mongodb时间
	 //程序要考虑如有一条解析失败，如何处理异常事件
	 //将解析失败的日记写入到另外一个文件？
	 //然后手工处理或者其他方式处理，这样子就会造成统计不准确，如果一条解析异常保存日志1·
	 public static void pareOneFile(String path) throws IOException{
		 long beginTime = System.currentTimeMillis();
		 File f = new File(path);
		 FileReader fr = new FileReader(f);
	     BufferedReader bf = new BufferedReader(fr);
	     String  readString = "";
	     while( (readString=bf.readLine())!= null){
	    	 //解析字符串
	         String[] ss = readString.split("\\|\\|");
	         for(int i = 0 ; i <ss.length ;i++){
	        	 System.out.println("===>"+ss[i]);
	         }
	         //插入mongodb
	         
	     }//end while
	     bf.close();
	     System.out.println("cost time is ===》"+(System.currentTimeMillis()-beginTime));
	 }

}
