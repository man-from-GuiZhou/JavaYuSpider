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
		 this.getRealUrl(zhihuUrl);//得到url地址后马上进行转换
	 }
	 @Override
	 public String toString() {
		 return "问题：" + question + "\n" + "描述：" + questionDescription + "\n"
				    + "链接：" + zhihuUrl + "\n回答：" + answers + "\n";
	 }
	 //将爬取到的答案url进行转换
	// 处理url
	 public boolean getRealUrl(String url) {
	  // 将http://www.zhihu.com/question/22355264/answer/21102139
	  // 转化成http://www.zhihu.com/question/22355264
	  // 否则不变 
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
