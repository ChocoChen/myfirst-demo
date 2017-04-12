package com.choco.demo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://www.baidu.com/s?wd=∂ˆ¡À√¥%20∆¿º€&rsv_spt=1&rsv_iqid=0xed22a71b00002572&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&rqlang=cn&tn=baiduhome_pg&rsv_enter=0&oq=sfwe&rsv_t=0fe5kwbI%2BtE9I6VkeOgY%2FvtzrEG6cU4FIBUlxmdeucFcSMZu00BPBPtn3marRCR%2BNSAl&inputT=2418&rsv_pq=d230e3ab00002758&rsv_sug3=7&rsv_sug1=4&rsv_sug7=100&bs=sfwe").get();
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
