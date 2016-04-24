package pkg;

import java.util.Scanner;

public class Vigenere_Algo {

	
	public static void main (String[] args)
	{
		
		//the no. of character in the key must be equal to no. of characters in the text
		// and we will deal with space character ' ', by putting 'A' character instead of it.
		String Key, PlainText;
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter PlainText :");
	    PlainText=sc.nextLine();
	    PlainText=PlainText.toUpperCase();
	    System.out.println("Enter Key: ");
	    Key=sc.nextLine();
	    Key=Key.toUpperCase();
	    char Key1[]=new char[Key.length()];
	    char PlainText1[]=new char[PlainText.length()];
	  
	    int x=0,z=0;
	    while(x<Key.length())
	    {
	    	PlainText1[x]=PlainText.charAt(z);
	        Key1[x]=Key.charAt(z);
	        z++;
	        if(z==Key.length())
	        	{ 
	        	z=0;
	        	}
	        x++;
	    }
	    
	    //	    encrypt(key1,PlainText1);      

		decrypt(encrypt(Key1,PlainText1),Key1);
		
	}
	
	
	

	public static char [] encrypt( char k[],char t[])
	{
	 
	    char cipherText[]=new char[t.length];

	    int VigenereTable[][]=new int[26][26];
	    
	    int aa=0, n=26;
	    int value;
	    for(int i=0;i<n;i++)
	    {
	        for(int j=0;j<n;j++)
	        {
	            value=j+aa;
	            if(value>25)
	            {
	                value=value-26;
	            }
	            VigenereTable[i][j]=value+65;
	        }
	    aa++;
	    }
	    
	      
	      
	     // this is for printing table i-e if you wish to see table too just uncomment this code!
	 /*       for(int i=0;i<n;i++)
	    	    {
	    	        for(int j=0;j<n;j++)

	    	            {
	    	           char b=(char)(VigenereTable[i][j]);
	    	            System.out.print(b);
	    	            System.out.print(" ");
	    	            }
	    	            System.out.println();
	    	    }
	   */ 	

	 
	    for(int x=0;x<t.length;x++)
	    {
	        int i=0;
	        int j=0;
	     for(int y=0;y<26;y++)
	     {
	         if(k[x]==VigenereTable[0][y])  
	                 i=y;
	         if(t[x]==VigenereTable[y][0])
	                 j=y;
	     }
	      cipherText[x]=(char)(VigenereTable[j][i]);   
	     }
	    System.out.println(cipherText);

	return cipherText;
	}

	public static char[] decrypt(char CipherText[], char key[])
	{
	    //int len=CipherText.length();
		  char[] PlainText=new char[key.length];
		  
		  int VigenereTable[][]=new int[26][26];
		    
		    int aa=0, n=26;
		    int value;
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            value=j+aa;
		            if(value>25)
		            {
		                value=value-26;
		            }
		            VigenereTable[i][j]=value+65;
		        }
		    aa++;
		    }
		    
		    /*	  
		     * 
		     *   this is for printing table i-e if you wish to see table too just uncomment this code!
		     *   for(int i=0;i<n;i++)
		    	    {
		    	        for(int j=0;j<n;j++)

		    	            {
		    	           char b=(char)(table[i][j]);
		    	            System.out.print(b);
		    	            System.out.print(" ");
		    	            }
		    	            System.out.println();
		    	    }
		    	*/

	 int s = 0;
	    for(int x=0;x<key.length;x++)
	    {
	        int i=0;
	        int j=0;
	     for(int y=0;y<26;y++)
	     {
	         if(key[x]==VigenereTable[y][0])  
	         {    
	         	for(s=0;s<26;s++)
	         	{
	         		if(CipherText[x]==VigenereTable[y][s])
	         		{
	         			j=s;
	         			//break;
	         
	         		}
	         	}
	         }
	
	
	
	     }
	    
	     PlainText[x]=(char)(VigenereTable[0][j]);   

	 
	    }
	     System.out.println(PlainText);
	    return PlainText;
	}	
	
	
	
	
}
