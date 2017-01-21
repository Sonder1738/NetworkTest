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
		
		
		System.out.println("This run?");
		Socket MyClient;
	    MyClient = new Socket("127.0.0.1", 15676);
	    
	    BufferedReader sin=new BufferedReader(new InputStreamReader(MyClient.getInputStream()));
		PrintStream sout=new PrintStream(MyClient.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (  true )
		{
			System.out.print("Client : ");
			s=stdin.readLine();
			sout.println(s);
			s=sin.readLine();
			System.out.print("Server : "+s+"\n");
  			if ( s.equalsIgnoreCase("BYE") )
 			   break;
		}

}
	
}