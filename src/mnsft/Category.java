package mnsft;
import mm22.Category.CategoryInfo;

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
		public int pagenum;
		
	}
	public static List<CategoryInfo> getCategory()
	{
		List<CategoryInfo> catamap = new LinkedList<CategoryInfo>();
		try
		{			
			CategoryInfo info = new CategoryInfo();
			info.href = "http://www.mnsfz.com/h/qingchun/";
			info.filename = "qingchun";
			info.pagenum = 18;
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.mnsfz.com/h/meihuo/";
			info.filename = "meihuo";
			info.pagenum = 21;
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.mnsfz.com/h/yangguang/";
			info.filename = "yangguang";
			info.pagenum = 17;
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.mnsfz.com/h/qiaopi/";
			info.filename = "qiaopi";
			info.pagenum = 22;
			catamap.add(info);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return catamap;
	}
}

