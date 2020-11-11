package controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;

import general.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class HomeScreenViewController implements Initializable {

    @FXML
    private Button connectionButton;
    @FXML
    private Button usersListRefreshButton;
    @FXML
    private Button messagesListRefreshButton;
    @FXML
    private Button senderButton;

    @FXML
    private Label connectionLabel;
    @FXML
    private Label recipientPseudoErrorLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private Label usersLabel;
    @FXML
    private Label pseudoLabel;

    @FXML
    private TextField pseudoTextField;
    @FXML
    private TextField recipientPseudoTextField;
    @FXML
    private TextField messageTextField;

    @FXML
    private ListView<String> clientsListView;
    @FXML
    private ListView<String> messagesListView;

    Dialogue myComponent;
    private ObservableList<String> usersObservableList;
    private ObservableList<String> messagesObservableList;
    private String connectedStatus;
    private String userPseudo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        connectionLabel.setVisible(false);
        recipientPseudoErrorLabel.setVisible(false);
        messageLabel.setVisible(false);
        usersLabel.setVisible(false);
        pseudoLabel.setVisible(false);

        connectedStatus = "false";
        userPseudo = "";
        messagesObservableList = FXCollections.observableArrayList();

        try {
            myComponent = (Dialogue) Naming.lookup("rmi://127.0.0.1:10000/Dialogue");
            usersObservableList = FXCollections.observableArrayList(myComponent.getClients());
            clientsListView.setItems(usersObservableList);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

        /*############ Images in buttons ######################
         *
         * Image imgPower = new Image("utils.images/power.png");
         * System.out.println("YOOOOOOOOOOOOOOOOOOOOOOOOOO"); ImageView viewPower = new
         * ImageView(imgPower); viewPower.setFitHeight(80);
         * viewPower.setPreserveRatio(true);
         *
         * Image imgRefresh = new Image("utils.images/refresh.png"); ImageView
         * viewRefresh = new ImageView(imgRefresh); viewRefresh.setFitHeight(80);
         * viewRefresh.setPreserveRatio(true);
         *
         * connectionButton.setGraphic(viewPower);
         * clientsListRefreshButton.setGraphic(viewRefresh);
         * messagesListRefreshButton.setGraphic(viewRefresh);
         */

        connectionButton.setOnAction(event -> {
            connectButtonClicked(event);
        });

        usersListRefreshButton.setOnAction(event -> {
            refreshClientsList(event);
        });

        messagesListRefreshButton.setOnAction(event -> {
            refreshMessagesList(event);
        });

        senderButton.setOnAction(event -> {
            sendMessage(event);
        });

    }

    private void connectButtonClicked(ActionEvent event) {
        String pseudo = pseudoTextField.getText();
        try {
            List<String> clientsList = myComponent.getClients();
            if (!clientsList.contains(pseudo) && userPseudo == "" && !pseudo.isEmpty()) {
                myComponent.connect(pseudo);
                userPseudo = pseudo;
                pseudoLabel.setText(userPseudo);
                pseudoLabel.setVisible(true);
                connectionLabel.setVisible(true);
                connectionLabel.setText("You've been connected successfully");
                pseudoTextField.clear();
                pseudoTextField.setPromptText("Enter your pseudo...");
                pseudoTextField.setVisible(false);
                connectedStatus = "true";
                connectionButton.setText("D");
            } else if (clientsList.contains(userPseudo) && connectedStatus == "true") {
                myComponent.disconnect(userPseudo);
                pseudoTextField.setVisible(true);
                userPseudo = "";
                pseudoLabel.setVisible(false);
                pseudoLabel.setText(userPseudo);
                connectedStatus = "false";
                connectionLabel.setVisible(true);
                connectionLabel.setText("You've been disconnected successfully");
                connectionButton.setText("C");
            } else if (pseudo.isEmpty() && userPseudo == ""){
                connectionLabel.setVisible(true);
                connectionLabel.setText("Please enter a pseudo");
                pseudoTextField.setPromptText("Enter your pseudo...");
                pseudoTextField.setVisible(true);
            } else if (!clientsList.contains(pseudo) && userPseudo == "" && !pseudo.isEmpty()) {
                connectionLabel.setVisible(true);
                connectionLabel.setText("This pseudo already exists !");
                pseudoTextField.setVisible(true);
            } else {
                connectionLabel.setVisible(true);
                connectionLabel.setText("There was a problem !");
            }
            refreshClientsList(event);
        } catch (RemoteException e) {
            e.printStackTrace();
            connectionLabel.setVisible(true);
            connectionLabel.setText("Error while connecting you");
        }
    }

    private void refreshClientsList(ActionEvent event) {
        try {
            usersObservableList = FXCollections.observableArrayList(myComponent.getClients());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (!(usersObservableList == null)) {
            clientsListView.setItems(usersObservableList);
            clientsListView.refresh();
        } else {
            usersLabel.setVisible(true);
            usersLabel.setText("Problem while loading the users list");
        }
    }

    private void refreshMessagesList(ActionEvent event) {
        try {
            messagesObservableList = FXCollections.observableArrayList(myComponent.getMessages(userPseudo));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (!(messagesObservableList == null)) {
            messagesListView.setItems(messagesObservableList);
            messagesListView.refresh();
        } else if (messagesObservableList == null) {
            messagesListView.setItems(FXCollections.observableArrayList(""));
            messagesListView.refresh();
        } else {
            messageLabel.setVisible(true);
            messageLabel.setText("Problem while loading the messages list");
        }
    }

    private void sendMessage(ActionEvent event) {
        String messageToSend = messageTextField.getText();
        String recipientPseudo = recipientPseudoTextField.getText();
        if (messageToSend.isEmpty()) {
            messageLabel.setVisible(true);
            messageLabel.setText("Please enter your message");
        } else if (recipientPseudo.isEmpty()) {
            recipientPseudoErrorLabel.setVisible(true);
            recipientPseudoErrorLabel.setText("Please enter the recipient pseudo");
        } else if (connectedStatus == "true" && !userPseudo.isEmpty() && !recipientPseudo.isEmpty()){
            try {
                myComponent.sendMessage(userPseudo, recipientPseudo, messageToSend);
                messageLabel.setVisible(false);
                recipientPseudoErrorLabel.setVisible(false);
                recipientPseudoTextField.clear();
                recipientPseudoTextField.setPromptText("Recipient pseudo...");
                messageTextField.clear();
                messageTextField.setPromptText("Your message...");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            messageLabel.setVisible(true);
            messageLabel.setText("There was a problem while sending your message");
        }
    }

}
