package telnet;

import java.net.*;
import java.io.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class server {

   public static void main(String args[]) throws Exception
	    {
	        ServerSocket Soc=new ServerSocket(1002);
	        while(true)
	        {
	            Socket CSoc=Soc.accept();
	            AcceptTelnetClient ob=new AcceptTelnetClient(CSoc);
	        }
	    }
	}

	class AcceptTelnetClient extends Thread
	{
	    Socket ClientSocket;
	    DataInputStream din;
	    DataOutputStream dout;
	    String LoginName;
	    String Password;

	    AcceptTelnetClient(Socket CSoc) throws Exception
	    {
	        ClientSocket=CSoc;
	        System.out.println("Client Connected ...");
	        DataInputStream din=new DataInputStream(ClientSocket.getInputStream());
	        DataOutputStream dout=new DataOutputStream(ClientSocket.getOutputStream());
	        
	        System.out.println("Waiting for UserName And Password");
	        
	        LoginName=din.readUTF();
	        Password=din.readUTF();
	            
	        start();        
	    }
	    public void run()
	    {
	        try
	        {    
	        DataInputStream din=new DataInputStream(ClientSocket.getInputStream());
	        DataOutputStream dout=new DataOutputStream(ClientSocket.getOutputStream());
            BufferedReader brFin=new BufferedReader(new FileReader("Password.txt"));

	        String LoginInfo=new String("");
	        boolean allow=false;
	        while((LoginInfo=brFin.readLine())!=null)
	        {
	            StringTokenizer st=new StringTokenizer(LoginInfo);
	            if(LoginName.equals(st.nextToken()) && Password.equals(st.nextToken()))
	            {
	                dout.writeUTF("ALLOWED");
	                allow=true;
	                break;
	            }
	        }
	        
	        brFin.close();

	        if (allow==false)
	        {
	            dout.writeUTF("NOT_ALLOWED");            
	        }
	        
	    

	        while(allow)
	        {
	            String strCommand;
	            strCommand=din.readUTF();
	            if(strCommand.equals("quit"))
	            {
	                allow=false;
	            }
	            else
	            {
	                Runtime rt=Runtime.getRuntime();
	            
	                Process p=rt.exec("TelnetServer.bat " + strCommand);
	                
	                String stdout=new String("");
	                String st;
	                DataInputStream dstdin=new DataInputStream(p.getInputStream());
	                while((st=dstdin.readLine())!=null)
	                {
	                    stdout=stdout +st + "\n";
	                }
	                dstdin.close();
	                dout.writeUTF(stdout);                        
	            }                        
	        }
	        ClientSocket.close();
	        }
	        catch(Exception ex)
	        {
	            ex.printStackTrace();
	        }
	    } 
	} 
