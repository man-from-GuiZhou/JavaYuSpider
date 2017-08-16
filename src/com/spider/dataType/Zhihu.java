package com.spider.dataType;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//专门用来存储爬取的知乎内容
public class Zhihu {
	public String question;// 问题
	 public String zhihuUrl;// 网页链接
	 public ArrayList<String> answers;// 存储所有回答的数组
	 public String questionDescription;//关于问题的描述
	 
	 // 构造方法初始化数据
	 public Zhihu() {
	  question = "";
	  zhihuUrl = "";
	  questionDescription="";
	  answers = new ArrayList<String>();
	 }
	 
	 public Zhihu(String url){
		 this.zhihuUrl=url;
	 }
	 @Override
	 public String toString() {
		 return "问题：" + question + "\n" + "描述：" + questionDescription + "\n"
				    + "链接：" + zhihuUrl + "\n回答：" + answers + "\n";
	 }
	 //将爬取到的答案url进行转换
	// 处理url
	 boolean getRealUrl(String url) {
	  // 将http://www.zhihu.com/question/22355264/answer/21102139
	  // 转化成http://www.zhihu.com/question/22355264
	  // 否则不变
	  Pattern pattern = Pattern.compile("question/(.*?)/");
	  Matcher matcher = pattern.matcher(url);
	  if (matcher.find()) {
	   zhihuUrl = "http://www.zhihu.com/question/" + matcher.group(1);
	  } else {
	   return false;
	  }
	  return true;
	 }
}
