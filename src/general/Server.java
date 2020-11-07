package general;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

public class Server {

	private List<String> clientsList = new ArrayList<String>();

	public static void main(String[] args) {
		try {
			// registry creation
			LocateRegistry.createRegistry(10000);

			// component instanciation and implicit activation
			DialogueImpl myComponent = new DialogueImpl();

			System.out.println(myComponent.getRef().remoteToString());

			// publication of component reference in the registry
			Naming.rebind("rmi://127.0.0.1:10000/Dialogue", myComponent);

			System.out.println("Serveur actif");

		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getClientsList() {
		return clientsList;
	}

	public void setClientsList(List<String> clientsList) {
		this.clientsList = clientsList;
	}
}
