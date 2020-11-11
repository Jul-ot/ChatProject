package model.server;

import model.client.Emitter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EmitterImpl extends UnicastRemoteObject implements Emitter {

    private String connectedStatus;
    private String userPseudo;

    protected EmitterImpl() throws RemoteException {
        super();
        connectedStatus = "false";
        userPseudo = "";
    }

    @Override
    public void sendMessage(String to, String message) {

    }

    public String getConnectedStatus() {
        return connectedStatus;
    }

    public void setConnectedStatus(String connectedStatus) {
        this.connectedStatus = connectedStatus;
    }

    public String getUserPseudo() {
        return userPseudo;
    }

    public void setUserPseudo(String userPseudo) {
        this.userPseudo = userPseudo;
    }
}
