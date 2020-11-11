package model.server;

import model.client.Connection;
import model.client.Emitter;

public class ConnectionImpl implements Connection {

    @Override
    public Emitter connect(String nickname, Receiver rcv) {
        return null;
    }

    @Override
    public void disconnect(String nickname) {

    }
}
