package mnsft;

import java.io.*;   

public class Download
{
	private static Download s_instance = null;
	private FileOutputStream out = null;   
	
	public static Download instance()
	{
		if(s_instance == null)
		{
			s_instance = new Download();
		}
		return s_instance;
	}

	
	private Download()
	{
		
	}
	
	public void create(String filename)
	{
		try
		{
			out = new FileOutputStream(new File("d:\\" + filename + ".txt"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void log(String str)
	{
		if(out != null)		
		{
			try
			{
				out.write((str + "\r\n").getBytes());
				System.out.println(str);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void destory()
	{
		try
		{
			if(out != null)
			{
				out.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
    public static String download(String url) throws IOException 
    { 
        StringBuffer cmdout = new StringBuffer(); 
        Process process = Runtime.getRuntime().exec("wget " + url);
        InputStream fis = process.getInputStream(); 
        BufferedReader br = new BufferedReader(new InputStreamReader(fis)); 
        String line = null; 
        while ((line = br.readLine()) != null) 
        { 
                cmdout.append(line); 
        } 
        
        System.out.println(cmdout.toString()); 
        return cmdout.toString().trim(); 
    } 
}
