package com.spider.dataType;

import java.util.ArrayList;

public class Zhihu {
	public String question;// ����
	 public String zhihuUrl;// ��ҳ����
	 public ArrayList<String> answers;// �洢���лش������
	 // ���췽����ʼ������
	 public Zhihu() {
	  question = "";
	  zhihuUrl = "";
	  answers = new ArrayList<String>();
	 }
	 @Override
	 public String toString() {
	  return "���⣺" + question + "\n���ӣ�" + zhihuUrl + "\n�ش�" + answers + "\n";
	 }
}
