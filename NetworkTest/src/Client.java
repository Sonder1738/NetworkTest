import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


//http://mrbool.com/file-transfer-between-2-computers-with-java/24516

public class Client{
	
	int portOut = 15678;
	
	Client() throws IOException{
			
		try{
			System.out.println("Connecting..");
			Thread.sleep(1000);
			clientIn ci = new clientIn();
			ci.clientIn();
			
		}catch(Exception e){
			System.out.println("No server online");
			
		}
			
	   
	   }

	public void start() throws UnknownHostException, IOException {
		clientIn ci = new clientIn();
		ci.clientIn();
		
	}

}

class clientOut extends Thread{
	
	
	
	public void clientOut(String msgIn, Socket a) throws UnknownHostException, IOException{
		
		PrintStream out=new PrintStream(a.getOutputStream());
		try{
			//does get input
			out.println(msgIn);
		}catch (Exception e){
			System.out.println(e);
		}
	}

	
}

class clientIn extends Thread{
	
	int portOut = 15678;
	Socket MyClient;
	public void clientIn () throws UnknownHostException, IOException{
		
		MyClient = new Socket("127.0.0.1", portOut);
		System.out.println("Connected to "+MyClient.getInetAddress().getHostAddress());
		
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (  true )
		{
			System.out.print("Client : ");
			s=stdin.readLine();
			
			clientOut co = new clientOut();
			co.clientOut(s, MyClient);
			
			if ( s.equalsIgnoreCase("BYE") )
 			   break;
		}
	   }
}


/*
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
//http://mrbool.com/file-transfer-between-2-computers-with-java/24516
public class Client {
	public static void main(String[] args) throws IOException{
			System.out.println("Starting server..");
			Server run = new Server();
			run.createSocketServer();
		try{
			System.out.println("Connecting..");
			Socket MyClient;
		    MyClient = new Socket("127.0.0.1", 15676);
		    System.out.println("Connected to " + MyClient.getInetAddress().getHostAddress());
		    BufferedReader sin=new BufferedReader(new InputStreamReader(MyClient.getInputStream()));
			PrintStream sout=new PrintStream(MyClient.getOutputStream());
			BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
			String s;
			while (  true )
			{
				MyClient = new Socket("127.0.0.1", 15676);
				System.out.print("Client : ");
				s=stdin.readLine();
				sout.println(s);
				s=sin.readLine();
				System.out.print("Server : "+s+"\n");
				
				
	  			if ( s.equalsIgnoreCase("BYE") )
	 			   break;
			}
		}catch (Exception e){
			System.out.println("No server online");
			System.out.println("Client closing..");
		}
		
		
	}
	
}
*/
