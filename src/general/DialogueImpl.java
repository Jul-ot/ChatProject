package general;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue {
	ArrayList<String> clientList;
	HashMap<String, ArrayList<String>> mapMessages;
	
	protected DialogueImpl() throws RemoteException {
		super();
		clientList = new ArrayList<String>();
		mapMessages = new HashMap<String, ArrayList<String>>();
		
		
		
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
	public void sendMessage(String from, String to, String message) throws RemoteException {
		// TODO Auto-generated method stub
		if (!mapMessages.containsKey(to)) {
			ArrayList<String> messageList = new ArrayList<String>();
			messageList.add(message);
			mapMessages.put(to, messageList);
			
		}
		else {
			ArrayList<String> messageList = mapMessages.get(to);
			messageList.add(message);
			mapMessages.replace(to, messageList);
		}
		System.out.println(from + ":" + message);
		
	}

	@Override
	public ArrayList<String> getMessages(String pseudo) throws RemoteException {
		// TODO Auto-generated method stub
		
		return mapMessages.get(pseudo);
	}
	
	

}
