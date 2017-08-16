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
	 
	 public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getZhihuUrl() {
		return zhihuUrl;
	}

	public void setZhihuUrl(String zhihuUrl) {
		this.zhihuUrl = zhihuUrl;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public Zhihu(String url){
		 this.zhihuUrl=url;
		 this.getRealUrl(zhihuUrl);//�õ�url��ַ�����Ͻ���ת��
	 }
	 @Override
	 public String toString() {
		 return "���⣺" + question + "\n" + "������" + questionDescription + "\n"
				    + "���ӣ�" + zhihuUrl + "\n�ش�" + answers + "\n";
	 }
	 //����ȡ���Ĵ�url����ת��
	// ����url
	 public boolean getRealUrl(String url) {
	  // ��http://www.zhihu.com/question/22355264/answer/21102139
	  // ת����http://www.zhihu.com/question/22355264
	  // ���򲻱� 
	  Pattern pattern = Pattern.compile("question/(.*?)/");
	  Matcher matcher = pattern.matcher(url);
	  if (matcher.find()) {
	   zhihuUrl = "https://www.zhihu.com/question/" + matcher.group(1);
	  } else {
	   return false;
	  }
	  return true;
	 }
}
