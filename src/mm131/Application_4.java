package mm131;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Application_4 
{

    public static void main(String[] args) 
    {
    	 List<Category.CategoryInfo> catamap = Category.getCategory();
    	
		try
		{
			for(int n = 0 ; n < catamap.size() ; n++)
			{
				Category.CategoryInfo cata = catamap.get(n);
				System.out.println("catamap " + n + " / " + catamap.size());
				String catahref = cata.href;
				String filename = cata.filename;
				
				Download.instance().create(filename);
				
				List<String> lstpage = TitleFile.getPages(catahref,cata.type,cata.pagenum);
				for(int i = 0 ; i < lstpage.size() ; i++)
				{
					System.out.println(filename + " Outer Page Count " + i + " / " + lstpage.size());
					
					String url = lstpage.get(i);
					List<String> lstpic = TitleFile.getTitles(url);
					
					for(int j = 0 ; j < lstpic.size() ; j++)
					{
						System.out.println(filename + " Current Page Size "+ j + " / " + lstpic.size());
						
						url = lstpic.get(j);
						List<String> lstsub = ContentFile.getSubPage(url);
						int t = 1;
						for(String href : lstsub)
						{
							System.out.println(filename + " Inner Size " + t++ + " / " + lstsub.size());
							List<String> lstinfo = ContentFile.getInfo(href);
							if(lstinfo != null)
							{
								for(int s = 0 ; s < lstinfo.size() ; s++)
								{
									Download.instance().log(lstinfo.get(s));
								}
							}
						}
					}
				}	
				
				Download.instance().destory();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}