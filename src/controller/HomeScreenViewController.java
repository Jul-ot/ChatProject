package controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;
import general.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeScreenViewController implements Initializable {

	@FXML
	private Button connectionButton;
	@FXML
	private Button clientsListRefreshButton;
	@FXML
	private Button messagesListRefreshButton;

	@FXML
	private Label connectionLabel;
	@FXML
	private Label recipierPseudoErrorLabel;
	@FXML
	private Label messageLabel;
	@FXML
	private Label usersLabel;

	@FXML
	private TextField pseudoTextField;
	@FXML
	private TextField recipierPseudoTextField;
	@FXML
	private TextField messageTextField;

	@FXML
	private TableView<String> clientsTableView;
	@FXML
	private TableView<String> messagesTableView;

	Dialogue myComponent;
	private ObservableList<String> usersObservableList;
	

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// TODO Auto-generated method stub

		connectionLabel.setVisible(false);
		recipierPseudoErrorLabel.setVisible(false);
		messageLabel.setVisible(false);
		usersLabel.setVisible(false);

		try {
			myComponent = (Dialogue) Naming.lookup("rmi://127.0.0.1:10000/Dialogue");
			usersObservableList = (ObservableList<String>) myComponent.getClients();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * ############ Images in buttons ######################
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

		clientsListRefreshButton.setOnAction(event -> {
			refreshClientsList(event);
		});

	}

	private void connectButtonClicked(ActionEvent event) {
		String pseudo = pseudoTextField.getText();
		try {
			List<String> clientsList = myComponent.getClients();
			if (!clientsList.contains(pseudo)) {
				myComponent.connect(pseudo);
				connectionLabel.setVisible(true);
				connectionLabel.setText("You've been connected successfully");
			} else {
				connectionLabel.setVisible(true);
				connectionLabel.setText("This pseudo already exists !");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			connectionLabel.setVisible(true);
			connectionLabel.setText("Error while connecting you");
		}
	}

	private void refreshClientsList(ActionEvent event) {
		try {
			usersObservableList = (ObservableList<String>) myComponent.getClients();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!(usersObservableList == null)) {
			clientsTableView.setItems(usersObservableList);
		} else {
			usersLabel.setVisible(true);
			usersLabel.setText("Problem while loading the users list");
		}
	}

}
