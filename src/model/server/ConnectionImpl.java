package model.server;

import model.client.Connection;
import model.client.Emitter;
import model.client.ReceiverImpl;
import model.client.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConnectionImpl extends UnicastRemoteObject implements Connection {

    protected ConnectionImpl() throws RemoteException {
        super();
    }

    @Override
    public Emitter connect(User user, Receiver rcv) {
        Emitter emitter = null;
        Receiver receiver = null;
        try {
            emitter = new EmitterImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return emitter;
    }

    @Override
    public void disconnect(User user) {

    }
}
