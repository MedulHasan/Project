
package signup;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class signup extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        signup.stage=stage;
        Parent parent = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene cn = new Scene(parent);
        stage.setScene(cn);
        stage.show();
    }
}
