
package login;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import forgetpassword.forgetpassword;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class LoginController implements Initializable {

    @FXML
    private JFXButton btnlogin;
     private Connection con=null;
      private PreparedStatement pst=null;
    private ResultSet rs=null;
    @FXML
    private JFXTextField txt_email;
    @FXML
    private JFXPasswordField txt_pass;
    @FXML
    private AnchorPane anchorpane1;
    @FXML
    private JFXButton signup;
    @FXML
    private Label lblwrongpass;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            con = dba.DBConnection.projectconnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handlelogin(ActionEvent event) throws IOException {
        if(txt_email.getText().equals(getEmail()) && txt_pass.getText().equals(getpasscode()))
        {
            
            /*Stage stage = (Stage)anchorpane1.getScene().getWindow();
            stage.close();
            Parent pa  = FXMLLoader.load(getClass().getResource("/user/user.fxml"));
            Scene cn = new Scene(pa);
            stage.setScene(cn);
            stage.show();*/
            Parent root = FXMLLoader.load(getClass().getResource("/library/system/Library.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Library Assistant Login ");
            
        }
        else if(txt_email.getText().equals("admin@gmail.com") && txt_pass.getText().equals("12345"))
        {

            Stage stage = (Stage)anchorpane1.getScene().getWindow();
            stage.close();
            Parent pa  = FXMLLoader.load(getClass().getResource("/admin/admin.fxml"));
            Scene cn = new Scene(pa);
            stage.setScene(cn);
            stage.show(); 
            
        }
         else
        {
            lblwrongpass.setText("Incorrect username or password");
            //Alert alert = new Alert(Alert.AlertType.NONE,"Invalid Email or PassCode",ButtonType.OK);
            //alert.setTitle("Invalid");
            //alert.showAndWait();
        }
        
    }
    
    private String getEmail()
    {
        String email = "";
        try {
            
            pst = con.prepareStatement("Select email from login2 where email=?");
            pst.setString(1,txt_email.getText());
            rs = pst.executeQuery();
            if(rs.next())
                email = rs.getString(1);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return email;
    }
    
    private String getpasscode()
    {
        String passcode = "";
        try {
            
            pst = con.prepareStatement("Select Password from login2 where email=?");
            pst.setString(1, txt_email.getText());
            rs = pst.executeQuery();
            if(rs.next())
                passcode = rs.getString(1);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passcode;
    }

    @FXML
    private void handlesignup(ActionEvent event) throws IOException {
        //Stage stage = (Stage)anchorpane1.getScene().getWindow();
        //stage.close();
        Parent parent = FXMLLoader.load(getClass().getResource("/signup/signup.fxml"));
        Scene cn = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(cn);
        stage.show();
        login.stage.close();
    }

    @FXML
    private void handleforgetpassword(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/forgetpassword/forgetpassword.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        //forgetpassword.stage.close();
    }
    
}
