package model.client;

import model.server.Receiver;

public interface Connection {
    Emitter connect(String nickname, Receiver rcv);
    void disconnect(String nickname);
}
