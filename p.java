


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
class FindFile 
{
	int i;
	 String operations;
	String Filepath = null;
	public String traverse(File file) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {   
    	
    	int j=0;
        File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
            	System.out.println(fil.getAbsolutePath());
            	traverse(fil);
                
                
            }
            else 
            {
            	RegexMatches rg=new RegexMatches();
            	Filepath = fil.getAbsolutePath();
            	System.out.println("String passed to reg Exp="+Filepath);
            	Boolean Regvalue=rg.CheckGroup(Filepath, "abc");
            	
            	System.out.println("Matched?? :"+Regvalue);
            	//if(Regvalue)
            	{
            	
            		System.out.println(Filepath);
            		if(j==0 ){
            			do{
            					System.out.println(" Select any one of the options: ");
            					System.out.println(" 1) Same operation  ");
            					System.out.println(" 2) Different operation ");
            					Scanner scan = new Scanner(System.in);
            					i = scan.nextInt();
            			}while(i!=1&&i!=2);
            	 
            			j++;
            	 
            			if(i==1){
            				Scanner scan = new Scanner(System.in); 
            				System.out.println("Enter the File operations"  );
            				operations = scan.next();
            			}
            		}
            		
            	if(i==1 )
            	{
            		reflection ref=new reflection();
                	ref.reflectall(Filepath,operations);
            	}
            	
            	else if(i==2)
            	{
            	reflection ref=new reflection();
            	ref.reflect(Filepath);
            	}
            }
            }
        }
		return Filepath;	
    }
  
	
	public String findFiletra(String name,File file)
    {   
    	
    	
        File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
            	//System.out.println(fil.getAbsolutePath());
            	findFiletra(name,fil);
                
                
            }
            else if (name.equalsIgnoreCase(fil.getName()))
            {
            	Filepath = fil.getAbsolutePath();
            	//System.out.println(Filepath);
            	
                
            }
        }
		return Filepath;
    }
}
