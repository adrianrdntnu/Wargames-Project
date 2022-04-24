package no.ntnu.iir.wargames;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Sets up the stage and loads the main fxml file.
 */
public class WargamesApplication extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("Wargames.fxml")); //TODO insert name of fxml file

      primaryStage.setTitle("Wargames");
      primaryStage.setScene(new Scene(root, 600, 300));
      primaryStage.show();
    } catch (IOException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }

  @Override
  public void stop() {
    System.exit(0);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
