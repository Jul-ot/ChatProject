package general;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue {
	
	private List<String> clientsList;
	private Map<String, List<String>> messages;
	
	protected DialogueImpl() throws RemoteException {
		super();
		this.clientsList = new ArrayList<String>();
		this.messages = new HashMap<String, List<String>>();
	}
	
	@Override
	public String sayHello(String message) throws RemoteException {
		return message;
	}

	@Override
	public void connect(String pseudo) throws RemoteException {
		if (clientsList.contains(pseudo)) {
			System.out.println("This pseudo already exists !");
		} else {
			this.clientsList.add(pseudo);
			System.out.println("You've been connected");
		}
	}

	@Override
	public void disconnect(String pseudo) throws RemoteException {
		if (clientsList.contains(pseudo)) {
			this.clientsList.remove(pseudo);
			System.out.println("You've been disconnected");
		} else {
			System.out.println("This pseudo doesn't exist !");
		}
	}

	@Override
	public List<String> getClients() throws RemoteException {
		return clientsList;
	}

	@Override
	public void sendMessage(String from, String to, String message) throws RemoteException {
		if (clientsList.contains(from)) {
			if (clientsList.contains(from)) {
				String messageToSend = from + " : " + message;
				if (messages.get(to) == null) {
					List<String> messageList = new ArrayList<String>();
					messageList.add(messageToSend);
					messages.put(to, messageList);
					System.out.println(messageList);
				} else {
					List<String> recipierMessages = messages.get(to);
					System.out.println("Messages of recipier : " + recipierMessages);
					recipierMessages.add(messageToSend);
					messages.put(to, recipierMessages);
					System.out.println(messageToSend);
				}

			} else {
				System.out.println("The recipier pseudo doesn't exist !");
			}
		} else {
			System.out.println("The sender pseudo doesn't exist !");
		}
	}

	@Override
	public List<String> getMessages(String pseudo) throws RemoteException {
		return messages.get(pseudo);
	}

}
