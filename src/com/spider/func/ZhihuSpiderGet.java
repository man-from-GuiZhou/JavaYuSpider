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
//import com.spider.othertools.PatternTool;
//���ڼ���ȡ֪���༭�Ƽ��ķ�����
public class ZhihuSpiderGet implements SpiderGet {

	
	//����Ҫ�����ĵ�����SpiderMainת�Ƶ��������,������ʹ���˿ɱ䳤��������֪��Ч����Σ�
	public ArrayList<Zhihu> specialWayGet(String...strings){
		
		if(strings.length!=3){
			System.out.println("Number of Parameters error");
			return null;
		}
		String text=this.getAllPage(strings[0]);
		ArrayList<Zhihu> results=this.getZhihu(text,strings[1], strings[2]);
		return results;
	}
	
	public String getAllPage(String Url) {
		// TODO Auto-generated method stub
		// ����һ���ַ��������洢��ҳ����
		  String result = "";
		  // ����һ�������ַ�������
		  BufferedReader in = null;
		  try {
		   // ��stringת��url����
		   URL realUrl = new URL(Url);
		   // ��ʼ��һ�����ӵ��Ǹ�url������
		   URLConnection connection = realUrl.openConnection();
		   // ��ʼʵ�ʵ�����
		   connection.connect();
		   // ��ʼ�� BufferedReader����������ȡURL����Ӧ
		   in = new BufferedReader(new InputStreamReader(
		     connection.getInputStream(), "UTF-8"));
		   // ������ʱ�洢ץȡ����ÿһ�е�����
		   String line;
		   while ((line = in.readLine()) != null) {
		    // ����ץȡ����ÿһ�в�����洢��result����
		    result += line;
		   }
		  } catch (Exception e) {
		   System.out.println("����GET��������쳣��" + e);
		   e.printStackTrace();
		  }
		  // ʹ��finally���ر�������
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
	public ArrayList<String> RegexStringList(String targetStr,String patternStr){
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
	
	public ArrayList<Zhihu> getZhihu(String targetStr,String questionPatternStr,
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
