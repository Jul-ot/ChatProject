package general;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dialogue myComponent;
		try {
			System.out.println("Please enter your message : ");
			Scanner scanner = new Scanner(System.in);
			myComponent = (Dialogue) Naming.lookup("rmi://127.0.0.1:10000/Dialogue");
			String myMessage = scanner.nextLine();
			System.out.println(myComponent.sayHello(myMessage));
			myComponent.sendMessage("Jules", "Julien", myMessage);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
