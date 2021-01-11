package model.client;

import model.server.Receiver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ReceiverImpl extends UnicastRemoteObject implements Receiver {

    protected ReceiverImpl() throws RemoteException {
    }

    @Override
    public void receive(String from, String message) {

    }

    @Override
    public void initClient(List<String> clients) {

    }

    @Override
    public void addClient(String client) {

    }

    @Override
    public void remClient(String client) {

    }
}
