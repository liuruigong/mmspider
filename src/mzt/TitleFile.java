package mzt;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class TitleFile 
{
	public static List<String> getTitles(String url)
	{
		List<String> lsttitles = new LinkedList<String>();
		try
		{
			
			Document doc = Jsoup.connect(url).timeout(30000).get();
			Element nav = doc.getElementById("postlist");
			
			Elements lis = nav.getElementsByTag("a");
			
			int i = 0;
			for (;i < lis.size() ;i++) 
			{
				  Element link = lis.get(i);
				  String href = link.attr("href");
				  if(lsttitles.contains(href)==false)
				  {
					  String alt = link.getElementsByTag("img").first().attr("alt");
					  System.out.println(i + "\t" + alt + "	=>	" + href);	
					  lsttitles.add(href);
				  }				  	  				  
				  
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lsttitles;
	}
	
	public static List<String> getPages(String url)
	{
		List<String> lsttitles = new LinkedList<String>();
		try
		{			
			Document doc = Jsoup.connect(url).timeout(30000).get();
			Element nav = doc.getElementById("pagenavi");
			
			Element lastlink = nav.select("a").last().previousElementSibling();
			String strnum = lastlink.text();
			int num = Integer.parseInt(strnum);
			int i = 0;
			for (i = 1 ; i <= num ; i++) 
			{
				if(i == 1)
				{
					lsttitles.add(url);
				}
				else
				{
					lsttitles.add(url + "/page/" + i);
				}
					
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lsttitles;
	}
}
