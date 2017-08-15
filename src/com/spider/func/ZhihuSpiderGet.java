package com.spider.func;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.spider.dataType.Zhihu;
import com.spider.funcInte.SpiderGet;
import com.spider.othertools.PatternTool;

public class ZhihuSpiderGet implements SpiderGet {

	
	//将主要方法的调用由SpiderMain转移到这个类中,在这里使用了可变长参数，不知道效果如何？
	public ArrayList<Zhihu> specialWayGet(String...strings){
		if(strings.length!=3){
			System.out.println("Number of Parameters error");
			return null;
		}
		String text=this.getAllPage(strings[0]);
		ArrayList<Zhihu> results=PatternTool.getZhihu(text,strings[1], strings[2]);
		return results;
	}
	
	public String getAllPage(String Url) {
		// TODO Auto-generated method stub
		// 定义一个字符串用来存储网页内容
		  String result = "";
		  // 定义一个缓冲字符输入流
		  BufferedReader in = null;
		  try {
		   // 将string转成url对象
		   URL realUrl = new URL(Url);
		   // 初始化一个链接到那个url的连接
		   URLConnection connection = realUrl.openConnection();
		   // 开始实际的连接
		   connection.connect();
		   // 初始化 BufferedReader输入流来读取URL的响应
		   in = new BufferedReader(new InputStreamReader(
		     connection.getInputStream(), "UTF-8"));
		   // 用来临时存储抓取到的每一行的数据
		   String line;
		   while ((line = in.readLine()) != null) {
		    // 遍历抓取到的每一行并将其存储到result里面
		    result += line;
		   }
		  } catch (Exception e) {
		   System.out.println("发送GET请求出现异常！" + e);
		   e.printStackTrace();
		  }
		  // 使用finally来关闭输入流
		  finally {
		   try {
		    if (in != null) {
		     in.close();
		    }
		   } catch (Exception e2) {
		    e2.printStackTrace();
		   }
		  }
		  return result;
	}

}
