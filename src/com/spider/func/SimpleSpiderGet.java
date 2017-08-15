package com.spider.func;

import java.io.*;
import java.net.*;
//import java.util.zip.GZIPInputStream;
import java.util.ArrayList;

import com.spider.dataType.Zhihu;
import com.spider.funcInte.SpiderGet;

public class SimpleSpiderGet implements SpiderGet{
	public String getAllPage(String Url){
		BufferedReader in = null;
		String result="";
		URL realUrl;
		try {
			realUrl = new URL(Url);
			URLConnection connection= realUrl.openConnection();
			//HttpURLConnection httpUrlConnection = (HttpURLConnection)connection;
			//httpUrlConnection.connect();
			//int code = httpUrlConnection.getResponseCode();
			//System.out.println(""+code);
			/*if(code==301){
				httpUrlConnection.disconnect();
				realUrl = new URL(httpUrlConnection.getHeaderField("Location"));
				System.out.println(httpUrlConnection.getHeaderField("Location"));
				httpUrlConnection = (HttpURLConnection) realUrl.openConnection();
				httpUrlConnection.connect();
			}*/
			connection.connect();
			//System.out.println(connection.getHeaderField("Location"));
			//realUrl=new URL(connection.getHeaderField("Location"));
			//connection=realUrl.openConnection();
			//connection.connect();
			//System.out.println(Url);
			//以ZIP的解码方式对乱码进行处理
			//InputStream urlStream = new GZIPInputStream(connection.getInputStream());
			//经验证上述方法无效
			InputStream urlStream = connection.getInputStream();
			/*in=new BufferedReader(new InputStreamReader
					(connection.getInputStream()));*/// 没有进行乱码修订之前

			in=new BufferedReader(new InputStreamReader(urlStream,"utf-8"));
			//in=new BufferedReader(new InputStreamReader(urlStream,"gbk"));
			
			String line="";	
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

	@Override
	public ArrayList<Zhihu> specialWayGet(String... strings) {
		// TODO Auto-generated method stub
		return null;
	}
}
