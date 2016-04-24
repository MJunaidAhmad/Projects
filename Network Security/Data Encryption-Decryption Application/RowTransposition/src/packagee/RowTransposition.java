
package packagee;

import java.util.Arrays;
import java.util.Scanner;

import java.util.*;


public class RowTransposition  
{

public static void main(String args[]) 
{
String key;
String Text = null;
String ct; 

int x=0; 

int y=0; 



System.out.print( "Enter Key : " );

Scanner sc = new Scanner(System.in);
key = sc.nextLine();
System.out.print( "Type your Message : " );
Text= sc.nextLine();



int msgchar = Text.length();
int keycahr = key.length();

if (!((msgchar % keycahr) == 0)){

do{
	Text = Text + "x";
msgchar = Text.length();
}while(!((msgchar % keycahr) == 0));

}


ct = "";

char xx[][]=new char [key.length()][Text.length()];
char tt[] = Text.toCharArray();

x=0;
y=0;

for (int i=0; i< tt.length;i++)
{
xx[x][y]=tt[i];
if (x==(key.length()-1)) 
{
x=0;
y=y+1;
} else 
{
x++;
}
} 
char t[]=new char [key.length()];
t=key.toCharArray();
Arrays.sort(t);
//this is for printing the mattix create by the algo. if you want to see uncomment this

/*for (int j=0;j<y;j++)
{
for (int i=0;i<key.length();i++)
{
System.out.print(xx[i][j]);
}
System.out.println();
}
*/
System.out.println();

for (int j=0;j<y;j++){ 
for (int i=0;i<key.length();i++){ 
int p=0;

for (p=0;p<t.length;p++){ 
if (key.charAt(i)==t[p]){ 
break;
}
}
System.out.print(xx[p][j]);
ct+=xx[p][j];
}
System.out.println();
}

System.out.println("CipherText is : "+ct);
System.exit(0);
}
}
