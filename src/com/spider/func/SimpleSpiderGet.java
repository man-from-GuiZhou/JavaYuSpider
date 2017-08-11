package com.spider.func;

import java.io.*;
import java.net.*;

import com.spider.funcInte.SpiderGet;

public class SimpleSpiderGet implements SpiderGet{
	public String getAllPage(String Url){
		
		String result="";
		BufferedReader in = null;
		URL realUrl;
		try {
			realUrl = new URL(Url);
			URLConnection connection= realUrl.openConnection();
			connection.connect();
			in=new BufferedReader(new InputStreamReader
					(connection.getInputStream()));
			String line;
			while((line=in.readLine())!=null){
				result+=line;
			}
			//return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("get request error");
			e.printStackTrace();
		}
		finally{
				try {
					if(in!=null){
						in.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(result);
		}
		return result;
	}
}
