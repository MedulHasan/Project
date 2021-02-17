
package user;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class user extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        user.stage=stage;
        Parent pa = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Scene cn = new Scene(pa);
        stage.setScene(cn);
        stage.show();
    }
    
}
