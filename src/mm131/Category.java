package mm131;
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
		public int type;
		
	}
	public static List<CategoryInfo> getCategory()
	{
		List<CategoryInfo> catamap = new LinkedList<CategoryInfo>();
		try
		{			
			CategoryInfo info = new CategoryInfo();
			info.href = "http://www.mm131.com/xinggan/";
			info.filename = "xinggan";
			info.pagenum = 23;
			info.type = 6;
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.mm131.com/qingchun/";
			info.filename = "qingchun2";
			info.pagenum = 25;
			info.type = 1;
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.mm131.com/xiaohua/";
			info.filename = "xiaohua";
			info.pagenum = 5;
			info.type = 2;
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.mm131.com/chemo/";
			info.filename = "chemo";
			info.pagenum = 8;
			info.type = 3;
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.mm131.com/qipao/";
			info.filename = "qipao";
			info.pagenum = 3;
			info.type = 4;
			catamap.add(info);
			
			info = new CategoryInfo();
			info.href = "http://www.mm131.com/mingxing/";
			info.filename = "mingxing";
			info.pagenum = 7;
			info.type = 5;
			catamap.add(info);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return catamap;
	}
}

