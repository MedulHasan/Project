
package login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class login extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        login.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene cn = new Scene(parent);
        stage.setScene(cn);
        stage.show();
        
    }
    
}
