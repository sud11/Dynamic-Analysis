import java.rmi.*;
public class Client{
	public static void main(String args[]){
		try{
			//AddServerInterface st=(AddServerInterface)Naming.lookup("rmi://"+args[0]+"/AddService");
			AddServerInterface st = (AddServerInterface) Naming.lookup("rmi://localhost:5000/sud");
			System.out.println(st.sum(4,2));
		}catch(Exception e){System.out.println(e);}
	}
}