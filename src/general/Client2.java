package general;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) {
		Dialogue myComponent;
		try {
			myComponent = (Dialogue) Naming.lookup("rmi://127.0.0.1:10000/Dialogue");
			myComponent.connect("Julien");
			System.out.println("List of connected clients : ");
			System.out.println(myComponent.getClients());
			System.out.println("Please enter your message : ");
			Scanner scanner = new Scanner(System.in);
			System.out.println(myComponent.getClients());
			System.out.println("Please enter your message : ");
			String myMessage = scanner.nextLine();
			scanner.close();
			myComponent.getMessages("Julien");
			myComponent.sendMessage("Julien", "Jules", myMessage);
			myComponent.disconnect("Julien");
			System.out.println(myComponent.getClients());
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

	}

}
