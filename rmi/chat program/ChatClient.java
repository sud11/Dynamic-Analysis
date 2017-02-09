    import java.rmi.*;
    import java.rmi.server.*;
    import java.util.*;
     
    public class ChatClient {
    	public static void main (String[] argv) {
    	    try {
    		    //	System.setSecurityManager(new RMISecurityManager());
    		    	Scanner s=new Scanner(System.in);
    		    	System.out.println("Enter Your name and press Enter:");
    		    	String name=s.nextLine().trim();		    		    	
    		    	ChatInterface client = new Chat(name);
       		    	ChatInterface server = (ChatInterface)Naming.lookup("rmi://localhost:5000/sud");
                    //lookup Returns a reference, a stub, for the remote object associated with the specified name.
    		    	String msg="["+client.getName()+"] got connected";
    		    	server.send(msg);
    		    	System.out.println("[System] Chat Remote Object is ready:");
    		    	server.setClient(client);
         		    	while(true){
    		    		msg=s.nextLine().trim();
    		    		msg="["+client.getName()+"] "+msg;		    		
    	    			server.send(msg);
    		    	}
     
    	    	}catch (Exception e) {
    	    		System.out.println("[System] Server failed: " + e);
    	    	}
    		}
    }

    /* One object is first binded to the RMI. The server is binded first. The client looks up for this in
    using host:port/name address and sets itself as a client for the server. For a client to send a message,
    it calls the server's send(). For the server to send message to client, it calls the server.client.send().
    This works because the client sets server.client when the client is made.
    How does it figure where to display the message (in the client's terminal or the server's terminal)?
    In client, server object is the looked up object and when server.send() is called, its a call in the remote function.*/

