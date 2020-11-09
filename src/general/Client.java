package general;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import example.Hello;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dialogue myComponent;
		try {
			System.out.println("Please enter your message : ");
			Scanner scanner = new Scanner(System.in);
			myComponent = (Dialogue) Naming.lookup("rmi://127.0.0.1:1099/Dialogue");
			String myMessage = scanner.nextLine();
			myComponent.sendMessage("Julien", "Jules", myMessage);
			System.out.println(myComponent.getClients());
		}
		catch (MalformedURLException | RemoteException | NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		

	}

}
