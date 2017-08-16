package com.spider.main;

import java.util.ArrayList;

import com.spider.dataType.Zhihu;
import com.spider.funcFactoryInte.VirtualFactory;
import com.spider.funcInte.SpiderGet;
//import com.spider.othertools.PatternTool;
import com.spider.othertools.XMLUtil;

public class SpiderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VirtualFactory factory;
		SpiderGet spiderGet;
		factory = (VirtualFactory) XMLUtil.getBean();
		spiderGet = factory.getSpiderWay();
		//�ɱ䶨�����������ݺ�����Ҫ�����÷���
		ArrayList<Zhihu> results=spiderGet.specialWayGet
				("https://www.zhihu.com/explore/recommendations",
						"<h2>.+?question_link.+?href=\"(.+?)\".+?</h2>");//"question_link.+?>(.+?)<",
						//"question_link.+?href=\"(.+?)\"");//"question_link.+?href=\"(.+?)\""
		if(results==null){
			System.out.println("function error");
		}
		else{
			for(Zhihu tempZhihu:results){
				System.out.println(tempZhihu.toString());;
			}
		}
		//spiderGet.
		//��ȡ�ٶ���ҳ���ݺͰٶȴ�צ��
		//missionMesInput("https://www.baidu.com/","\\bsrc=(//?.+(png|gif)\\s\\b)+",spiderGet);

		//��ȡ֪���ı༭�Ƽ�
		//missionMesInput("http://www.zhihu.com/explore/recommendations","question_link.+?>(.+?)<",spiderGet);
		//��https���ӻ������ض���
		
		//zhihuMissionMesInput("https://www.zhihu.com/explore/recommendations","question_link.+?>(.+?)<",spiderGet);
		
		/*String result=spiderGet.getAllPage("https://www.baidu.com/");
		//String imgSrc = PatternTool.RegexString(result, "src=\"//(.+?)\"");
		//����ʹ�����������ȡ���ı����ݷ����˸ı䣬û��������
		String imgSrc = PatternTool.RegexString(result, "\\bsrc=(//?.+(png|gif)\\s\\b)+");
		System.out.println("ͼƬ��ַ:");
		System.out.println(imgSrc);*/
		
		
	}
	
	//������ǰ��ȡ�ٶ���ҳ���ٶ�logo�Լ�֪���༭�Ƽ���Ϣ�ķ��������������ڵĳ���
	/*
	static void missionMesInput(String URL,String Regex,SpiderGet sg){//��������Ϣ�������������ָ��
		String result=sg.getAllPage(URL);
		String imgSrc=PatternTool.RegexString(result, Regex);
		//System.out.println("ͼƬ��ַ:");
		System.out.println(imgSrc);
	}
	
	static void zhihuMissionMesInput(String URL,String Regex,SpiderGet sg){
		String result=sg.getAllPage(URL);
		ArrayList<String> questions=PatternTool.RegexStringList(result, Regex);
		System.out.println(questions);
	}*/

}
