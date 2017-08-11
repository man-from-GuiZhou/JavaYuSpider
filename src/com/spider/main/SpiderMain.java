package com.spider.main;

import com.spider.funcFactoryInte.VirtualFactory;
import com.spider.funcInte.SpiderGet;
import com.spider.othertools.XMLUtil;

public class SpiderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VirtualFactory factory;
		SpiderGet spiderGet;
		factory = (VirtualFactory) XMLUtil.getBean();
		spiderGet = factory.getSpiderWay();
		spiderGet.getAllPage("https://www.baidu.com/");
	}

}
