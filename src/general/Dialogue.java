package general;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Dialogue extends Remote {
	
	String sayHello(String message) throws RemoteException;
	void connect(String pseudo) throws RemoteException;
	void disconnect(String pseudo) throws RemoteException;
	String[] getClients() throws RemoteException;
	void sendMessage(String from, String to, String message) throws RemoteException;
	String[] getMessages(String pseudo) throws RemoteException;
	
}
