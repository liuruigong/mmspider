package mm22;

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
			Element nav = doc.select(".c_inner").last();			
			Elements lis = nav.getElementsByTag("ul");
			
			int i = 0;
			for (;i < lis.size() ;i++) 
			{
				  Element link = lis.get(i);
				  Elements aset = link.getElementsByTag("a");
				  for(int j = 0 ; j < aset.size() ; j++)
				  {
					  Element aa = aset.get(j);
					  String href = "http://www.22mm.cc" + aa.attr("href");
					  String title = aa.attr("title");
					  if(lsttitles.contains(href)==false)
					  {
						  System.out.println(i + "\t" + title + "	=>	" + href);	
						  lsttitles.add(href);
					  }		
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
			Element nav = doc.select(".ShowPage").last();
			
			Element lastlink = nav.select("span").first();
			String strnum = lastlink.text().replaceAll("¹²", "");
			strnum = strnum.replaceAll("Ì×Í¼Æ¬", "");
			int count = Integer.parseInt(strnum);
			int num = Math.round( (float)count / (float)35 );
			int i = 0;
			for (i = 1 ; i <= num ; i++) 
			{
				if(i == 1)
				{
					lsttitles.add(url);
				}
				else
				{
					lsttitles.add(url + "index_" + i + ".html");
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
