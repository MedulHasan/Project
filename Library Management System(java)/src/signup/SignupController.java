
package signup;

import login.*;

import createanewaccount.createanewaccount;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SignupController implements Initializable {

    
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXPasswordField confirmpassword;
    @FXML
    private JFXPasswordField upassword;
    @FXML
    private JFXComboBox<login1> combox;
    private ObservableList<login1> regs;
    @FXML
    private JFXTextField suseremail;
    private Connection con=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    private String id;
    @FXML
    private Label lblerror;
    @FXML
    private Label lblerror1;
    @FXML
    private Label lblconfirm;
    @FXML
    private JFXButton backbutton;
    @FXML
    private AnchorPane anchorpane2;
    @FXML
    //private JFXButton signup;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        regs = FXCollections.observableArrayList();
        try {
            con = dba.DBConnection.projectconnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                pst=con.prepareStatement("select * from login1");
                rs = pst.executeQuery();
                while(rs.next())
                {
                    regs.add(new login1(rs.getString(1),rs.getString(2)));
                }
                combox.setItems(regs);

                
            } catch (SQLException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       combox.setConverter(new StringConverter<login1>() {
                    @Override
                    public String toString(login1 object) {
                        return object.getName();
                    }

                    @Override
                    public login1 fromString(String string) {
                        return null;
                    }
                });
       combox.valueProperty().addListener((obs,oldValue,newValue)->{
           if(newValue!=null)
           {
               
               id = newValue.getID();
           }
       });
    }    

    @FXML
    private void handlesignup(ActionEvent event) throws IOException {
        boolean isValidEmail = createanewaccount.isValidEmail(suseremail,lblerror,".");
        boolean isPasswordMatched = createanewaccount.isPasswordMatched(upassword,confirmpassword,lblerror1,".");
        if(isValidEmail && isPasswordMatched)
        {
            try {
                //lblerror.setText(" ");
                //lblerror1.setText(" ");
                
                String add ="insert into login2(Email,Password,FirstName,LastName,ID) values(?,?,?,?,?)";
                pst = con.prepareStatement(add);
                pst.setString(1,suseremail.getText());
                pst.setString(2,upassword.getText());
                pst.setString(3,firstname.getText());
                pst.setString(4,lastname.getText());
                pst.setString(5,id);
                int i = pst.executeUpdate();
                if(i==1)
                {
                    //Alert alert = new Alert(Alert.AlertType.INFORMATION,"Registation Successfully",ButtonType.OK);
                    //alert.show();
                    lblconfirm.setText("Registation Successfully");
                    /*Parent parent = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
                    Scene cn = new Scene(parent);
                    //Stage stage = new Stage();
                    stage.setScene(cn);
                    stage.show();
                    //signup.stage.close();*/
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            lblconfirm.setText("Registation UnSuccessfully Please try again");
        }
        
    }

    @FXML
    private void handlebackbutton(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
        Scene cn = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(cn);
        stage.show();
        //signup.stage.close();
        
    }
    
}
