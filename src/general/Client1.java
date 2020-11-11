package general;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client1 {
	
	private String myPseudo = "";
	
	public Client1(String myPseudo) {
		super();
		this.myPseudo = myPseudo;
	}

	public static void main(String[] args) {
		Dialogue myComponent;
		try {
			myComponent = (Dialogue) Naming.lookup("rmi://127.0.0.1:10000/Dialogue");
			myComponent.connect("Jules");
			System.out.println("List of connected clients : ");
			System.out.println(myComponent.getClients());
			System.out.println("Please enter your message : ");
			Scanner scanner = new Scanner(System.in);
			String myMessage = scanner.nextLine();
			scanner.close();
			myComponent.sendMessage("Jules", "Julien", myMessage);
			myComponent.getMessages("Jules");
			myComponent.disconnect("Jules");
			myComponent.getClients();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	public String getMyPseudo() {
		return myPseudo;
	}

	public void setMyPseudo(String myPseudo) {
		this.myPseudo = myPseudo;
	}
	
	

}
