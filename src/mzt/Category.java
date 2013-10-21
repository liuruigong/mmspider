package mzt;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.List;

public class Category
{
	public static void getCategory(List<String> catamap)
	{
		try
		{
			catamap.add("http://www.mzitu.com/category/mm");
			catamap.add("http://www.mzitu.com/category/japan");
			catamap.add("http://www.mzitu.com/category/model");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
