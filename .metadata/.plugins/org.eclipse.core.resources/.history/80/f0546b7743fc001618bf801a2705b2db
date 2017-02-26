/* A server as before, but this time it will remain 'open' for 
 * additional connection once a client has quit. The server can handle 
 * at most one connection at a time. */
import java.net.*;
import java.io.*;

public class AlwaysOnChatServer implements Runnable {
	private Socket socket = null;
	private ServerSocket server = null;
	private Thread thread = null;
	private DataInputStream streamIn = null;
	
	public AlwaysOnChatServer(int port)
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
				System.out.println("Waiting for client ... ");
				socket = server.accept();
				System.out.println("Client accepted: " + socket);
				open();
				boolean done = false;
				while(!done)
				{
					try
					{
						String line = streamIn.readUTF();
						System.out.println(line);
						done = line.equals(".bye");
						
					}
					catch(IOException ioe)
					{
						done = true;
					}
				}
				close();
			}
			catch(IOException ie)
			{
				System.out.println("Acceptance Error: " +ie );
			}
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
	public void open() throws IOException
	{
		streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	}
	public void close() throws IOException
	{
		if(socket != null)
			socket.close();
		if(streamIn != null)
			streamIn.close();
	}
	public static void main(String args[])
	{
		AlwaysOnChatServer server = null;
		if(args.length!=1)
			System.out.println("Usage: java ChatServer port");
		else
			server = new AlwaysOnChatServer(Integer.parseInt(args[0]));
	}
	
}