package com.spider.othertools;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spider.dataType.Zhihu;

public class PatternTool {
	
	public static String RegexString(String targetStr,String patternStr){
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(targetStr);
		if(matcher.find()){
			System.out.println("found");
			return matcher.group(1);
		}
		return "nothing";
	}//针对百度首页的简单爬虫所使用的匹配算法
	
	public static ArrayList<String> RegexStringList(String targetStr,String patternStr){
		  // 预定义一个ArrayList来存储结果
		  ArrayList<String> results = new ArrayList<String>();
		  // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		  Pattern pattern = Pattern.compile(patternStr);
		  // 定义一个matcher用来做匹配
		  Matcher matcher = pattern.matcher(targetStr);
		  // 如果找到了
		  boolean isFind = matcher.find();
		  // 使用循环将所有问题加入到结果中
		  while (isFind) {
		   //添加成功匹配的结果
		   results.add(matcher.group(1));
		   // 继续查找下一个匹配对象
		   isFind = matcher.find();
		  }
		  return results;
	}
	
	public static ArrayList<Zhihu> getZhihu(String targetStr,String questionPatternStr,
			String hrefPatternStr){
		//预定义存储结果
		ArrayList<Zhihu> results = new ArrayList<Zhihu>();
		//匹配标题
		Pattern questionPattern = Pattern.compile(questionPatternStr);
		Matcher questionMatcher = questionPattern.matcher(targetStr);
		//匹配url,问题的链接
		Pattern urlPattern = Pattern.compile(hrefPatternStr);
		Matcher urlMatcher= urlPattern.matcher(targetStr);
		//需要同时匹配到标题和链接
		boolean isFind=(questionMatcher.find()&&urlMatcher.find());
		while(isFind){
			Zhihu zhihuTemp = new Zhihu();
			zhihuTemp.question=questionMatcher.group(1);
			zhihuTemp.zhihuUrl="http://www.zhihu.com"+urlMatcher.group(1);
			results.add(zhihuTemp);
			isFind=questionMatcher.find()&&urlMatcher.find();
		}
		return results;
	}
	
}
