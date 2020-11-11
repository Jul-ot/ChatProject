package model.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Dialogue myComponent;
		try {
			myComponent = (Dialogue) Naming.lookup("rmi://127.0.0.1:10000/Dialogue");
			myComponent.connect("Jules");
			myComponent.connect("Julien");
			System.out.println("List of connected clients : ");
			System.out.println(myComponent.getClients());
			System.out.println("Please enter your message : ");
			Scanner scanner = new Scanner(System.in);
			String myMessage = scanner.nextLine();
			scanner.close();
			myComponent.sendMessage("Jules", "Julien", myMessage);
			myComponent.sendMessage("Julien", "Jules", "Ok bro");
			myComponent.getMessages("Jules");
			myComponent.getMessages("Jules");
			myComponent.disconnect("Jules");
			myComponent.getClients();
			myComponent.disconnect("Julien");
			myComponent.getClients();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

	}

}
