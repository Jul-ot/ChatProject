package general;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Dialogue extends Remote {
	
	String sayHello() throws RemoteException;
	
}
