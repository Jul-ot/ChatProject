package model.server;

import java.util.List;

public interface Receiver {
    void receive(String from, String message);
    void initClient(List<String> clients);
    void addClient(String client);
    void remClient(String client);
}
