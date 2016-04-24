package dfgf;

import java.util.*;

public class PolyalphabetCipher {

public static char cipherText[];

public static void main(String... s)
{
    //createVigenereTable();
    Scanner sc=new Scanner(System.in);
    String key, text;

    System.out.println("Enter the keyword");
    key=sc.nextLine();
    key=key.toUpperCase();
    System.out.println("Enter text to be encrypted");
    text=sc.nextLine();
    text=text.toUpperCase();
    System.out.println(text);
    encrypt(key,text);      
	decrypt1(cipherText,key);

}
public static int[][] createVigenereTable()
{
    int table[][]=new int[26][26];
    int rem=0, n=26;
    int value;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            value=j+rem;
            if(value>25)
            {
                value=value-26;
            }
            table[i][j]=value+65;
        }
    rem++;
    }

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)

            {
           char b=(char)(table[i][j]);
            System.out.print(b);
            System.out.print(" ");
            }
            System.out.println();
    }
    return table;

  }


//keyword::row and t=plainText::column
public static void encrypt(String k, String t)
{
    int len=k.length();
    char keyword[]=new char[t.length()];
    for(int i=0, j=0;i<t.length();i++)
    {
        keyword[i]=k.charAt(j);
        j++;
        if(j==len)
            j=0;

    }
    cipherText=new char[t.length()];

    int vigenere[][]=new int[26][26];
    vigenere=createVigenereTable();
    for(int x=0;x<t.length();x++)
    {
        int i=0;
        int j=0;
     for(int y=0;y<26;y++)
     {
         if(keyword[x]==vigenere[0][y])  
                 i=y;
         if(t.charAt(x)==vigenere[y][0])
                 j=y;
     }
      cipherText[x]=(char)(vigenere[j][i]);   
     }
    System.out.println(cipherText);
    }

public static void decrypt1(char c[], String k)
{
 int len=k.length();
    char kw[]=new char[c.length];
 
    for(int i=0, j=0;i<c.length;i++)
    {
 
        kw[i]=k.charAt(j);
        j++;
        if(j==len)
            j=0;

    }
    char pt[]=new char[c.length];

  int vigenere[][]=new int[26][26];
    vigenere=createVigenereTable();
 int s = 0;
    for(int x=0;x<kw.length;x++)
    {
        int i=0;
        int j=0;
     for(int y=0;y<26;y++)
     {
         if(kw[x]==vigenere[y][0])  
         {    
          for(s=0;s<26;s++)
          {
          if(c[x]==vigenere[y][s])
          {
          j=s;
          //break;
         
          }
          }
         }
     }
    
     pt[x]=(char)(vigenere[0][j]);   

 
    }
     System.out.println(pt);
}
} 

