
package AddBook;

import com.jfoenix.controls.JFXTextField;
import dba.DBConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.sql.*;
import javafx.stage.Stage;
public class AddBookController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField author;
    @FXML
    private JFXTextField publisher;

    private DBConnection connectDB;
    
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        connectDB=new DBConnection();
        
        
    }    

    @FXML
    private void addBook(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        String mtitle=title.getText();
        String mid=id.getText();
        String mauthor=author.getText();
        String mpublisher=publisher.getText();
        
        
        if(mtitle.isEmpty()|| mid.isEmpty() || mauthor.isEmpty()||mpublisher.isEmpty()){
            
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Field Must Not Be Empty");
            alert.showAndWait();
            return;
        }
        
        String sql="INSERT INTO tb_addBook(title,id,author,publisher)VALUES(?,?,?,?)";
        Connection conn=DBConnection.projectconnection();
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setString(1,mtitle);
        pst.setString(2,mid );
        pst.setString(3,mauthor);
        pst.setString(4, mpublisher);
        
        pst.execute();
        
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Book Added Successsfully");
            alert.showAndWait();
            title.setText(" ");
            id.setText(" ");
            author.setText(" ");
            publisher.setText(" ");
            return;
        
        
    }

    @FXML
    private void cancelbtn(ActionEvent event) {
        Stage stage=(Stage)anchorpane.getScene().getWindow();
        stage.close();
    }
    
}
