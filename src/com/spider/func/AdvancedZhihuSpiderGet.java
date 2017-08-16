package com.spider.func;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spider.dataType.Zhihu;
import com.spider.funcInte.SpiderGet;

public class AdvancedZhihuSpiderGet implements SpiderGet {

	@Override
	public ArrayList<Zhihu> specialWayGet(String... strings) {
		// TODO Auto-generated method stub
		String text=this.getAllPage(strings[0]);
		ArrayList<Zhihu> results=this.advancedGetZhihu(text,strings[1]);
		return results;	
		//return null;
	}

	@Override
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
	
	public ArrayList<Zhihu> advancedGetZhihu(String url,String targetPattern){
		// 预定义一个ArrayList来存储结果
		  ArrayList<Zhihu> results = new ArrayList<Zhihu>();
		  // 用来匹配url，也就是问题的链接
		  Pattern urlPattern = Pattern.compile(targetPattern);
		  Matcher urlMatcher = urlPattern.matcher(url);
		  // 是否存在匹配成功的对象
		  boolean isFind = urlMatcher.find();
		  //先不循环爬取，确定爬取无误后再循环
		 // while (isFind) {
		   // 定义一个知乎对象来存储抓取到的信息
		   Zhihu zhihuTemp = new Zhihu(urlMatcher.group(1));
		   zhihuTemp=this.fillZhihu(zhihuTemp);
		   // 添加成功匹配的结果
		   results.add(zhihuTemp);
		   // 继续查找下一个匹配对象
		   isFind = urlMatcher.find();
		//  }
		  return results;
	}
	//根据已经有url但其他信息为空的zhihu进行内容的填充
	public Zhihu fillZhihu(Zhihu zh){
		 String url=zh.zhihuUrl;
		// if (zh.getRealUrl(url)) {
			   System.out.println("正在抓取" + url);
			   // 根据url获取该问答的细节
			   String content = this.getAllPage(url);
			   //System.out.println(content);
			   Pattern pattern;
			   Matcher matcher;
			   // 匹配标题
			  // pattern = Pattern.compile("zh-question-title.+?<h2.+?>(.+?)</h2>");
			   //成功！爬取到了问题的标题
			   pattern = Pattern.compile("QuestionHeader-title\">(.+?)<");
			   matcher = pattern.matcher(content);
			   if (matcher.find()) {
				//   System.out.println("questionFound");
			   // zh.question = matcher.group(1);
			    zh.setQuestion(matcher.group(1));
			    //System.out.println(matcher.group(1));
			   }
			   // 匹配描述
			   //pattern = Pattern.compile("zh-question-detail.+?<div.+?>(.*?)</div>");
			   pattern = Pattern.compile("QuestionHeader-detail.+?<div.+?>(.*?)</div>");
			   //QuestionAnswers-answers
			  // pattern = Pattern.compile("QuestionAnswers-answers.+?<div.+?>(.*?)</div>");
			   matcher = pattern.matcher(content);
			   if (matcher.find()) {
				   System.out.println("questionDescriptionFound");
				   zh.questionDescription = matcher.group(1);
			   }
			   // 匹配答案
			   pattern = Pattern.compile("/answer/content.+?<div.+?>(.*?)</div>");
			   matcher = pattern.matcher(content);
			   boolean isFind = matcher.find();
			   while (isFind) {
				   System.out.println("AnswersFound");
				   zh.answers.add(matcher.group(1));
			    isFind = matcher.find();
			   }
		//	}
		 return zh;
		}
}
