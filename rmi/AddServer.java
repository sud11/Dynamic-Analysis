import java.rmi.*;
import java.rmi.registry.*;
public class AddServer{
	public static void main(String args[]){
		try{
			AddServerInterface addService=new Adder();
			Naming.rebind("rmi://localhost:5000/sud",addService);	
			System.out.println("ERE");
		}catch(Exception e){System.out.println(e);}
	}
}