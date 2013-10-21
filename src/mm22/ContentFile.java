package mm22;

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
			Element nav = doc.getElementById("box-inner");
			Element tmp = nav.getElementsByTag("script").get(1);
			if(tmp != null)
			{
				String txt = tmp.html();
				String arr[] = txt.split(";");
				int length = arr.length;
				if(length > 1)
				{
					for(int i = 1; i <= length - 2 ; i++)
					{
						String tmp1 = arr[i];					
						tmp1 = tmp1.split("=")[1];
						tmp1 = tmp1.replaceAll("/big/", "/pic/");
						tmp1 = tmp1.replaceAll("\"", "");
						lsttitles.add(tmp1);
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
			
			Element nav = doc.select(".pagelist").last();
			Elements tmps = nav.select("a");
			int num = tmps.size() - 1;
			for(int i = 1 ; i <= num ; i++)
			{
				if(i == 1)
				{
					lsttitles.add(url);
				}
				else
				{
					String tmp = url;
					tmp = tmp.replaceAll(".html", "-" + i + ".html");
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
