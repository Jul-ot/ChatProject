package general;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue {
	
	ArrayList<String> clientList;
	
	protected DialogueImpl() throws RemoteException {
		super();
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect(String pseudo) throws RemoteException {
		// TODO Auto-generated method stub
		if (clientList.indexOf(pseudo) == -1) {
			clientList.add(pseudo);
		}
	}

	@Override
	public void disconnect(String pseudo) throws RemoteException {
		// TODO Auto-generated method stub
		clientList.remove(pseudo);
		
	}

	@Override
	public ArrayList <String> getClients() throws RemoteException {
		// TODO Auto-generated method stub
		return clientList;
	}

	@Override
	public void sendMessage(String from, String to, String message) {
		// TODO Auto-generated method stub
		
	}
	
	

}
