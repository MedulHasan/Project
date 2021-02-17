/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgetpassword;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import createanewaccount.createanewaccount;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ForgetpasswordController implements Initializable {

    @FXML
    private JFXPasswordField savenew;
    @FXML
    private JFXPasswordField saveconfirm;
    @FXML
    private JFXButton changesave;
    @FXML
    private JFXTextField email;

    private Connection con=null;
    private PreparedStatement pst=null;
    @FXML
    private Label lblsuccess;
    @FXML
    private Label lalerror2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            con = dba.DBConnection.projectconnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForgetpasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handlechangesave(ActionEvent event) throws SQLException {
        boolean isPasswordMatched = createanewaccount.isPasswordMatched(savenew,saveconfirm,lalerror2,".");
        if(isPasswordMatched)
        {
        String update = "update login2 set Password = ? where Email = ?";
        String EMail = email.getText();
        String PAssword = savenew.getText();
        pst = con.prepareStatement(update);
        pst.setString(1, PAssword);
        pst.setString(2, EMail);
        
        int i = pst.executeUpdate();
        if(i == 1)
        {
            lblsuccess.setText("Password Change Successfully");
        }
        }
        else
        {
            lblsuccess.setText("New Password & Confirm Password dose not match");
        }
       
    }
    
}
