import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		Server s = new Server();
		s.start();
		Thread.sleep(5000);
		Client c = new Client();
		c.start();
		
		
		/*
		       try{
		          while(c.client.isAlive() && s.server.isAlive())
		          {
		            System.out.println("Main threaaaaad will be alive till the child thread is live"); 
		            Thread.sleep(1000);
		          }
		       }catch(InterruptedException e){
		          System.out.println("Main thread interrupted");
		       }
		       System.out.println("Main thread run is over" );
		    
*/
		
	}

}
