package com.spider.funcFactory;

import com.spider.func.AdvancedZhihuSpiderGet;
import com.spider.funcFactoryInte.VirtualFactory;
import com.spider.funcInte.SpiderGet;

public class AdvancedZhihuConFactory implements VirtualFactory {

	@Override
	public SpiderGet getSpiderWay() {
		// TODO Auto-generated method stub
		SpiderGet asg= new AdvancedZhihuSpiderGet(); 
		return asg;
	}

}
