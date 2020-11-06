package general;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import example.Hello;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dialogue myComponent;
		try {
			myComponent = (Dialogue) Naming.lookup("Hello");
			System.out.println(myComponent.sayHello());
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
