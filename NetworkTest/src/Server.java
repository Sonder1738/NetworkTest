import java.io.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable{

	
	ServerSocket ssock;
    int portIn = 15676;
    private Thread t;
    Socket client;
	
	Thread server;


	
	protected void serverIn()
    {
		try
        {
            while (true){
            	System.out.println("Server listening..");
            	ssock = new ServerSocket(portIn);
                client = ssock.accept();
                System.out.println(client.getInetAddress().getHostAddress() +" connected ");
                
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String line;
                int time =0;
                while((line=input.readLine())!=null){ 
                  System.out.println("Client :"+line);
                  time++;
                  if(time==50){
                	  break;
                  }
                  }
                
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
            System.out.println(client.getInetAddress().getHostAddress()+" Disconnected");
        }
    }
	


	
	public void run(){
		
		serverIn();
		}
	
public void start() {
		
		System.out.println("Starting Server Thread");
	      if (t == null) {
	         t = new Thread (this, "svr thrd");
	         t.start ();
	      }
		
	}


	
		
		
}
class serverOut extends Thread{
	
}
class serverIn extends Thread{
	
}







