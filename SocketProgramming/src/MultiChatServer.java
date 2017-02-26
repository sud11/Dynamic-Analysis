/*Step 3: A server as before, but this time it can handle multiple clients simultaneously. 
 * The output from all connected clients will appear on the server's screen.
 */
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
public class MultiChatServer implements Runnable
{
	private ServerSocket server = null;
	private Thread thread = null;
	private ChatServerThread client = null;
	
	public MultiChatServer(int port)
	{
		try
		{
			System.out.println("Binding to port " + port + ", please wait  ...");
			server = new ServerSocket(port);
			System.out.println("Server started: " + server);
	        start();
		}
		catch(IOException ioe)
		{
			System.out.println(ioe);
		}
	}
	public void run()
	{
		while(thread!=null)
		{	
			try
			{	
			System.out.println("Waiting for a client...");
			addThread(server.accept());
			}
			catch(IOException ie)
			{
				System.out.println("Acceptance Error:"+ie);
			}
		}
	}
	public void addThread(Socket socket)
	{
		System.out.println("Client accepted:"+socket);
		client = new ChatServerThread(this,socket);
		try
		{
			client.open();
			client.start();
		}
		catch (IOException ioe)
		{
			System.out.println("Error opening thread:"+ ioe);
		}
		
	}
	public void start()
	{
		if(thread == null)
		{	
			//Allocates a new Thread object.
			/*Parameter is the object whose run method is invoked 
			 * when this thread is started. If null, this classes 
			 * run method does nothing.
			 */
			thread = new Thread(this);
			thread.start();
			
		}
	}
	public static void main(String args[])
	{
		MultiChatServer server = null;
		if(args.length!=1)
			System.out.println("Usage: java ChatServer port");
		else
			server = new MultiChatServer(Integer.parseInt(args[0]));
	}
	
}	

