package model.client;

import java.rmi.Remote;

public interface Emitter extends Remote {
    void sendMessage(String to, String message);
}
