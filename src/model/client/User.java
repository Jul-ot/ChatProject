package model.client;

public class User {
    private String username;
    private String connectionStatus;

    public User(String username, String connectionStatus) {
        this.username = username;
        this.connectionStatus = connectionStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}
