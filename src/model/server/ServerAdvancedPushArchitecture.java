package model.server;

import model.client.ReceiverImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerAdvancedPushArchitecture {

    public static void main(String[] args) {
        try {
            // Registry creation
            LocateRegistry.createRegistry(10000);

            // Component instantiation and implicit activation
            ConnectionImpl myConnectionComponent = new ConnectionImpl();

            System.out.println(myConnectionComponent.getRef().remoteToString());

            // Publication of component reference in the registry
            Naming.rebind("rmi://127.0.0.1:10000/Connection", myConnectionComponent);

            System.out.println("Serveur actif");

        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
