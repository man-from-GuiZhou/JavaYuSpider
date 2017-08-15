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
	}//��԰ٶ���ҳ�ļ�������ʹ�õ�ƥ���㷨
	
	public static ArrayList<String> RegexStringList(String targetStr,String patternStr){
		  // Ԥ����һ��ArrayList���洢���
		  ArrayList<String> results = new ArrayList<String>();
		  // ����һ����ʽģ�壬����ʹ��������ʽ����������Ҫץ������
		  Pattern pattern = Pattern.compile(patternStr);
		  // ����һ��matcher������ƥ��
		  Matcher matcher = pattern.matcher(targetStr);
		  // ����ҵ���
		  boolean isFind = matcher.find();
		  // ʹ��ѭ��������������뵽�����
		  while (isFind) {
		   //��ӳɹ�ƥ��Ľ��
		   results.add(matcher.group(1));
		   // ����������һ��ƥ�����
		   isFind = matcher.find();
		  }
		  return results;
	}
	
	public static ArrayList<Zhihu> getZhihu(String targetStr,String questionPatternStr,
			String hrefPatternStr){
		//Ԥ����洢���
		ArrayList<Zhihu> results = new ArrayList<Zhihu>();
		//ƥ�����
		Pattern questionPattern = Pattern.compile(questionPatternStr);
		Matcher questionMatcher = questionPattern.matcher(targetStr);
		//ƥ��url,���������
		Pattern urlPattern = Pattern.compile(hrefPatternStr);
		Matcher urlMatcher= urlPattern.matcher(targetStr);
		//��Ҫͬʱƥ�䵽���������
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
