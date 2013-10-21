package mm131;

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
			Element nav = doc.select(".content-pic").last();
			Element tmp = nav;
			if(tmp != null)
			{
				Elements imgs = tmp.select("img");
				for(int i = 0 ; i < imgs.size() ; i++)
				{
					Element img = imgs.get(i);
					String src = img.attr("src");
					lsttitles.add(src);
				}
				
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
			
			Element nav = doc.select(".content-page").last();
			Elements tmps = nav.select("a");
			int num = tmps.size() ;
			for(int i = 1 ; i <= num ; i++)
			{
				if(i == 1)
				{
					lsttitles.add(url);
				}
				else
				{
					String tmp = url;
					tmp = tmp.replaceAll(".html", "_" + i + ".html");
					lsttitles.add(tmp);
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
