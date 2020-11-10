package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewController extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		try {
			BorderPane root = new BorderPane();

			FXMLLoader chatApplicationLoader = new FXMLLoader(getClass().getResource("/view/HomeScreen.fxml"));
			root.setCenter(chatApplicationLoader.load());

			/*
			 * FXMLLoader menuLoader = new
			 * FXMLLoader(getClass().getResource("/view/SideMenu.fxml"));
			 * root.setLeft(menuLoader.load());
			 */

			Scene scene = new Scene(root);

			primaryStage.setScene(scene);
			primaryStage.setTitle("Chat Project");
			primaryStage.setHeight(700);
			primaryStage.setWidth(1300);
			primaryStage.show();
			primaryStage.centerOnScreen();

		} catch (IOException e) {
			System.out.println("Erreur lors du chargement de la scène : \n" + e.getMessage());
		}

		/*
		 * BorderPane root = new BorderPane();
		 * 
		 * Scene scene = new Scene(root);
		 * 
		 * primaryStage.setScene(scene); primaryStage.setTitle("Chat Project");
		 * primaryStage.setHeight(700); primaryStage.setWidth(1300);
		 * primaryStage.show(); primaryStage.centerOnScreen();
		 */

	}

}
