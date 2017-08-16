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
		//可变定长参数，根据后续需要调整该方法
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
		//爬取百度首页内容和百度大爪子
		//missionMesInput("https://www.baidu.com/","\\bsrc=(//?.+(png|gif)\\s\\b)+",spiderGet);

		//爬取知乎的编辑推荐
		//missionMesInput("http://www.zhihu.com/explore/recommendations","question_link.+?>(.+?)<",spiderGet);
		//非https链接会遭遇重定向
		
		//zhihuMissionMesInput("https://www.zhihu.com/explore/recommendations","question_link.+?>(.+?)<",spiderGet);
		
		/*String result=spiderGet.getAllPage("https://www.baidu.com/");
		//String imgSrc = PatternTool.RegexString(result, "src=\"//(.+?)\"");
		//不能使用这个正则，爬取的文本内容发生了改变，没有了引号
		String imgSrc = PatternTool.RegexString(result, "\\bsrc=(//?.+(png|gif)\\s\\b)+");
		System.out.println("图片地址:");
		System.out.println(imgSrc);*/
		
		
	}
	
	//用于先前爬取百度首页、百度logo以及知乎编辑推荐信息的方法，不适用现在的程序
	/*
	static void missionMesInput(String URL,String Regex,SpiderGet sg){//将爬虫信息的输入和主程序分割开来
		String result=sg.getAllPage(URL);
		String imgSrc=PatternTool.RegexString(result, Regex);
		//System.out.println("图片地址:");
		System.out.println(imgSrc);
	}
	
	static void zhihuMissionMesInput(String URL,String Regex,SpiderGet sg){
		String result=sg.getAllPage(URL);
		ArrayList<String> questions=PatternTool.RegexStringList(result, Regex);
		System.out.println(questions);
	}*/

}
