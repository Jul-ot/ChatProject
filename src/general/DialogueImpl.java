package general;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue {
	
	protected DialogueImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello world";
	}

}
