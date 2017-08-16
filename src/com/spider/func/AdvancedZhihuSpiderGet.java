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
	
	public ArrayList<Zhihu> advancedGetZhihu(String url,String targetPattern){
		// Ԥ����һ��ArrayList���洢���
		  ArrayList<Zhihu> results = new ArrayList<Zhihu>();
		  // ����ƥ��url��Ҳ�������������
		  Pattern urlPattern = Pattern.compile(targetPattern);
		  Matcher urlMatcher = urlPattern.matcher(url);
		  // �Ƿ����ƥ��ɹ��Ķ���
		  boolean isFind = urlMatcher.find();
		  //�Ȳ�ѭ����ȡ��ȷ����ȡ�������ѭ��
		 // while (isFind) {
		   // ����һ��֪���������洢ץȡ������Ϣ
		   Zhihu zhihuTemp = new Zhihu(urlMatcher.group(1));
		   zhihuTemp=this.fillZhihu(zhihuTemp);
		   // ��ӳɹ�ƥ��Ľ��
		   results.add(zhihuTemp);
		   // ����������һ��ƥ�����
		   isFind = urlMatcher.find();
		//  }
		  return results;
	}
	//�����Ѿ���url��������ϢΪ�յ�zhihu�������ݵ����
	public Zhihu fillZhihu(Zhihu zh){
		 String url=zh.zhihuUrl;
		// if (zh.getRealUrl(url)) {
			   System.out.println("����ץȡ" + url);
			   // ����url��ȡ���ʴ��ϸ��
			   String content = this.getAllPage(url);
			   //System.out.println(content);
			   Pattern pattern;
			   Matcher matcher;
			   // ƥ�����
			  // pattern = Pattern.compile("zh-question-title.+?<h2.+?>(.+?)</h2>");
			   //�ɹ�����ȡ��������ı���
			   pattern = Pattern.compile("QuestionHeader-title\">(.+?)<");
			   matcher = pattern.matcher(content);
			   if (matcher.find()) {
				//   System.out.println("questionFound");
			   // zh.question = matcher.group(1);
			    zh.setQuestion(matcher.group(1));
			    //System.out.println(matcher.group(1));
			   }
			   // ƥ������
			   //pattern = Pattern.compile("zh-question-detail.+?<div.+?>(.*?)</div>");
			   pattern = Pattern.compile("QuestionHeader-detail.+?<div.+?>(.*?)</div>");
			   //QuestionAnswers-answers
			  // pattern = Pattern.compile("QuestionAnswers-answers.+?<div.+?>(.*?)</div>");
			   matcher = pattern.matcher(content);
			   if (matcher.find()) {
				   System.out.println("questionDescriptionFound");
				   zh.questionDescription = matcher.group(1);
			   }
			   // ƥ���
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
