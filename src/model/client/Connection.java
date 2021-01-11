package model.client;

import model.server.Receiver;

import java.rmi.Remote;

public interface Connection extends Remote {
    Emitter connect(User user, Receiver rcv);
    void disconnect(User user);
}
