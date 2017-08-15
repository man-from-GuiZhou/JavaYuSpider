package com.spider.func;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.spider.dataType.Zhihu;
import com.spider.funcInte.SpiderGet;
import com.spider.othertools.PatternTool;

public class ZhihuSpiderGet implements SpiderGet {

	
	//����Ҫ�����ĵ�����SpiderMainת�Ƶ��������,������ʹ���˿ɱ䳤��������֪��Ч����Σ�
	public ArrayList<Zhihu> specialWayGet(String...strings){
		if(strings.length!=3){
			System.out.println("Number of Parameters error");
			return null;
		}
		String text=this.getAllPage(strings[0]);
		ArrayList<Zhihu> results=PatternTool.getZhihu(text,strings[1], strings[2]);
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

}
