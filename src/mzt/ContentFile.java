package mzt;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ContentFile 
{
	public static List<String> getInfo(String url)
	{
		List<String> lsttitles = new LinkedList<String>();
		try
		{						
			Document doc = Jsoup.connect(url).timeout(30000).get();
			
			if(doc == null)
			{
				return null;
			}
			Element nav = doc.select(".main-body").first();
			Element tmp = nav.getElementsByTag("img").first();
			if(tmp != null)
			{
				String src = tmp.attr("src");
				lsttitles.add(src);
			}
						
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lsttitles;
	}
	
	public static List<String> getSubPage(String url)
	{
		List<String> lsttitles = new LinkedList<String>();
		try
		{
			Document doc = Jsoup.connect(url).timeout(30000).get();
			
			if(doc == null)
			{
				return null;
			}
			Element nav = doc.select(".link_pages").first();
			Elements tmps = nav.select("a");
			int num = tmps.size() - 4;
			for(int i = 1 ; i <= num ; i++)
			{
				if(i == 1)
				{
					lsttitles.add(url);
				}
				else
				{
					lsttitles.add(url + "/" + i);
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
