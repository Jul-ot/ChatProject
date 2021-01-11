package model.server;

import model.client.ReceiverImpl;

import java.rmi.Remote;
import java.util.List;

public interface Receiver extends Remote {
    void receive(String from, String message);
    void initClient(List<String> clients);
    void addClient(String client);
    void remClient(String client);
}
