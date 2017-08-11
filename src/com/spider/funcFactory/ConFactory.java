package com.spider.funcFactory;

import com.spider.func.SimpleSpiderGet;
import com.spider.funcFactoryInte.VirtualFactory;
import com.spider.funcInte.SpiderGet;

public class ConFactory implements VirtualFactory {

	public SpiderGet getSpiderWay() {
		// TODO Auto-generated method stub
		SpiderGet SG = new SimpleSpiderGet();
		return SG;
	}
}
