package mm22;
import mnsft.Category.CategoryInfo;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Category
{
	public static class CategoryInfo
	{
		public String href ;
		public String filename;
		
	}
	public static List<CategoryInfo> getCategory()
	{
		List<CategoryInfo> catamap = new LinkedList<CategoryInfo>();
		try
		{			
			CategoryInfo info = new CategoryInfo();
			info.href = "http://www.22mm.cc/mm/qingliang/";
			info.filename = "qingliang";
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.22mm.cc/mm/jingyan/";
			info.filename = "jingyan";
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.22mm.cc/mm/bagua/";
			info.filename = "bagua";
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.22mm.cc/mm/suren/";
			info.filename = "suren";
			catamap.add(info);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return catamap;
	}
}
