package com.spider.funcFactory;

import com.spider.func.ZhihuSpiderGet;
import com.spider.funcFactoryInte.VirtualFactory;
import com.spider.funcInte.SpiderGet;

public class ZhihuConFactory implements VirtualFactory {

	@Override
	public SpiderGet getSpiderWay() {
		// TODO Auto-generated method stub
		SpiderGet zSG = new ZhihuSpiderGet();
		return zSG;
	}

}
