
package AddMember;

import com.jfoenix.controls.JFXTextField;
import dba.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AddMemberController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField mobile;
    @FXML
    private JFXTextField email;
    

    private DBConnection connectDB;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        connectDB=new DBConnection();
        
    }    

    @FXML
    private void addbtn(ActionEvent event) throws SQLException, ClassNotFoundException {
      
        String mname=name.getText();
        String mid=id.getText();
        String mmobile=mobile.getText();
        String memail=email.getText();
        
            
        if(mname.isEmpty()|| mid.isEmpty() || mmobile.isEmpty()||memail.isEmpty()){
            
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill The Text Fields");
            alert.showAndWait();
            return;
        }
        
        String sql="INSERT INTO AddMember(Name,MemberID,Mobile,Email)VALUES(?,?,?,?)";
        Connection conn=DBConnection.projectconnection();
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setString(1,mname);
        pst.setString(2,mid );
        pst.setString(3,mmobile);
        pst.setString(4, memail);
        
        pst.execute();
        
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Member Added Successsfully");
            alert.showAndWait();
            name.setText(" ");
            id.setText(" ");
            mobile.setText(" ");
            email.setText(" ");
        
        
        
    }

    @FXML
    private void cancelbtn(ActionEvent event) {
        
         Stage stage=(Stage)anchorpane.getScene().getWindow();
        stage.close();
    }
    
}
