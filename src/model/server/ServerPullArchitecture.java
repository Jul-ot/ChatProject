package model.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerPullArchitecture {

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
			e.printStackTrace();
		}
	}
}
