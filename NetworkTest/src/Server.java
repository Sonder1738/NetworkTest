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

public class Server {

	static Socket serverSocket = null;
	
	public static void main(String[] args) throws IOException{
		
		start();
		
		}
	
	public static void start() throws IOException{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Press 1 to start server");
		System.out.println("Press 2 to end server");
		System.out.println("Press 3 to start chatting");
		System.out.println("Please select number");
		
		int choice;
		choice = in.nextInt();
		
		switch (choice){
		
		case 1: startsvr();
		break;
		case 2: closesvr();
		break;
		case 3: startchat();
		break;
		default : System.out.println("You entered something else");
		
		}
		
	}
	
	public static void startsvr(){
		ServerSocket MyService = null;
		
	    try {
	    	System.out.println("This server is waiting for connection");
	    	MyService = new ServerSocket(15676);
	        }
	        catch (IOException e) {
	           System.out.println(e);
	           
	        }
	    
	    
	    try {
	    	serverSocket = MyService.accept();
	    	System.out.println("Connection successful");
	    	System.out.println("Client connected with IP: "+serverSocket.getInetAddress().getHostAddress());
	    	
	    	start();
	    }catch (IOException e) {
	       System.out.println(e);
	    }
	}

	public static void closesvr() throws IOException{
		serverSocket.close();
	}
	public static void startchat() throws IOException{
		
		BufferedReader cin=new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		PrintStream cout=new PrintStream(serverSocket.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (  true )
		{
			
			s=cin.readLine();
  			if (s.equalsIgnoreCase("END"))
  			{
				cout.println("BYE");
    				break;
  			  }
			System. out.print("Client : "+s+"\n");
			System.out.print("Server : ");
			s=stdin.readLine();
			cout.println(s);
		}
	}
}
