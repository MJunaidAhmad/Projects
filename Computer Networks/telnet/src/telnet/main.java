package telnet;
import java.net.*;
import java.io.*;

class TelnetClient
{
    public static void main(String args[]) throws Exception
    {
        Socket soc=new Socket("10.0.0.1",23);
        String LoginName;
        String Password;
        String Command;
        
        
        DataInputStream din=new DataInputStream(soc.getInputStream());        
        DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to Telnet Client");
        System.out.println("Your Credential Please...");
        System.out.print("Login Name :");

        LoginName=br.readLine();
        
        System.out.print("Password :");
        Password=br.readLine();
        
        dout.writeUTF(LoginName);
        dout.writeUTF(Password);

        if (din.readUTF().equals("ALLOWED"))
        {
            do
            {
            System.out.print("< Telnet Prompt >");
            Command=br.readLine();            
            dout.writeUTF(Command);
            if(!Command.equals("quit"))
            {
                System.out.println(din.readUTF());        
            }                
            }while(!Command.equals("quit"));
        }
        soc.close();        
    }
}