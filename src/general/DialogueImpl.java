package general;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue {
	
	protected DialogueImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String sayHello(String message) throws RemoteException {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void connect(String pseudo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect(String pseudo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getClients() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessage(String from, String to, String message) throws RemoteException {
		// TODO Auto-generated method stub
		String messageToSend = "Message from " + from + " to " + to + " : " + message;
		System.out.println(messageToSend);
	}

	@Override
	public String[] getMessages(String pseudo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	//*/

}
