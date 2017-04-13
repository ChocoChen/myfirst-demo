package com.choco.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Demo1 {
	//https://www.zhihu.com/question/36132174
	public static void main(String[] args) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httppost = new HttpGet("https://www.baidu.com/s");
		
		 
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("wd", "∂ˆ¡À√¥%20∆¿º€"));
		formParams.add(new BasicNameValuePair("rsv_spt", "1"));
		formParams.add(new BasicNameValuePair("rsv_iqid", "0xed22a71b00002572"));
		formParams.add(new BasicNameValuePair("issp", "1"));
		formParams.add(new BasicNameValuePair("f", "8"));
		formParams.add(new BasicNameValuePair("rsv_bp", "1"));
		formParams.add(new BasicNameValuePair("rsv_idx", "2"));
		formParams.add(new BasicNameValuePair("ie", "utf-8"));
		formParams.add(new BasicNameValuePair("rqlang", "cn"));
		formParams.add(new BasicNameValuePair("tn", "baiduhome_pg"));
		formParams.add(new BasicNameValuePair("rsv_enter", "0"));
		formParams.add(new BasicNameValuePair("oq", "sfwe"));
		formParams.add(new BasicNameValuePair("rsv_t", "0fe5kwbI%2BtE9I6VkeOgY%2FvtzrEG6cU4FIBUlxmdeucFcSMZu00BPBPtn3marRCR%2BNSAl"));
		formParams.add(new BasicNameValuePair("inputT", "2418"));
		formParams.add(new BasicNameValuePair("rsv_pq", "d230e3ab00002758"));
		formParams.add(new BasicNameValuePair("rsv_sug3", "7"));
		formParams.add(new BasicNameValuePair("rsv_sug1", "4"));
		formParams.add(new BasicNameValuePair("rsv_sug7", "100"));
		formParams.add(new BasicNameValuePair("bs", "sfwe"));x
		
		Document doc = Jsoup.connect("https://www.baidu.com/s?&=&=&=&=").get();
		Elements h3Texts = doc.select("h3");
//		System.out.println(h3Texts);
		Document doc1 = Jsoup.parse(h3Texts.toString());
		Elements hrefTexts = doc1.select("a[href]");
		for(Element hrefText : hrefTexts) {
			String url = hrefText.attr("href");
//			System.out.println(url);
		}
		Elements pageText = doc.select("#page");
		System.out.println(pageText);
	}
}
