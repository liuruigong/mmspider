package mzt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Application_1 
{

    public static void main(String[] args) 
    {
    	List<String> catamap = new LinkedList<String>();
    	Category.getCategory(catamap);
    	
		try
		{
			for(int n = 0 ; n < catamap.size() ; n++)
			{
				System.out.println("catamap " + n + " / " + catamap.size());
				String catahref = catamap.get(n);
				List<String> lstpage = TitleFile.getPages(catahref);
				for(int i = 0 ; i < lstpage.size() ; i++)
				{
					System.out.println("lstpage " + i + " / " + lstpage.size());
					
					String url = lstpage.get(i);
					List<String> lstpic = TitleFile.getTitles(url);
					
					for(int j = 0 ; j < lstpic.size() ; j++)
					{
						System.out.println("lstpic " + j + " / " + lstpic.size());
						
						url = lstpic.get(j);
						List<String> lstsub = ContentFile.getSubPage(url);
						int t = 1;
						for(String href : lstsub)
						{
							System.out.println("lstsub " + t++ + " / " + lstsub.size());
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
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}