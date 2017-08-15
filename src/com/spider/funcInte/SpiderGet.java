package com.spider.funcInte;

import java.util.ArrayList;

import com.spider.dataType.Zhihu;

public interface SpiderGet {
	public ArrayList<Zhihu> specialWayGet(String...strings);
	public String getAllPage(String Url);
}
