package com.spider.dataType;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//ר�������洢��ȡ��֪������
public class Zhihu {
	public String question;// ����
	 public String zhihuUrl;// ��ҳ����
	 public ArrayList<String> answers;// �洢���лش������
	 public String questionDescription;//�������������
	 
	 // ���췽����ʼ������
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
		 return "���⣺" + question + "\n" + "������" + questionDescription + "\n"
				    + "���ӣ�" + zhihuUrl + "\n�ش�" + answers + "\n";
	 }
	 //����ȡ���Ĵ�url����ת��
	// ����url
	 boolean getRealUrl(String url) {
	  // ��http://www.zhihu.com/question/22355264/answer/21102139
	  // ת����http://www.zhihu.com/question/22355264
	  // ���򲻱�
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
