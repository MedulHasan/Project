
package forgetpassword;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class forgetpassword extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        forgetpassword.stage=stage;
        Parent root = FXMLLoader.load(getClass().getResource("forgetpassword.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
