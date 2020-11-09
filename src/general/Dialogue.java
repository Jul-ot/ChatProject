package general;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Dialogue extends Remote {
	
	void connect(String pseudo) throws RemoteException;
	void disconnect(String pseudo) throws RemoteException;
	ArrayList<String> getClients () throws RemoteException;
	void sendMessage (String from, String to, String message);
	
}
