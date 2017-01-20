import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{
		
		

		ServerSocket MyService = null;
		
	    try {
	       MyService = new ServerSocket(15678);
	        }
	        catch (IOException e) {
	           System.out.println(e);
	           
	        }
	    
	    Socket clientSocket = null;
	    try {
	    	clientSocket = MyService.accept();
	    	System.out.println("accepted.connected");
	        }
	    catch (IOException e) {
	       System.out.println(e);
	    }
	    
	    
	    
	    
		}

}
