
package MemberList;

import BookList.BookListController;
import dba.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class MemberListController implements Initializable {

    @FXML
    private TableView<Member> tableview;
    @FXML
    private TableColumn<Member, String> namecol;
    @FXML
    private TableColumn<Member, String> idcol;
    @FXML
    private TableColumn<Member, String> mobilecol;
    @FXML
    private TableColumn<Member, String> emailcol;
     private DBConnection connectDB;
    
     
     ObservableList<Member> list=FXCollections.observableArrayList();
    @FXML
    private TextField tfname;
    @FXML
    private TextField tfmobile;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfemail;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initCol();
        connectDB =new DBConnection();
        try {
             try {
                 loadData();
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(MemberListController.class.getName()).log(Level.SEVERE, null, ex);
             }
        } catch (SQLException ex) {
            Logger.getLogger(BookListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
     public void initCol(){
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        mobilecol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        emailcol.setCellValueFactory(new PropertyValueFactory<>("email"));
    }
    public void loadData() throws SQLException, ClassNotFoundException{
        String sql="SELECT * FROM AddMember";
        Connection con;
        try{
                
                con=DBConnection.projectconnection();
        PreparedStatement pst=con.prepareStatement(sql);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            String name=rs.getString("name");
            String id=rs.getString("MemberID");
            String mobile=rs.getString("mobile");
            String email=rs.getString("email");
            
            list.add(new Member(name,id,mobile,email));
        }
        }catch(SQLException ex){
            Logger.getLogger(BookListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableview.getItems().setAll(list);
        
    }

    @FXML
    private void ShowInfo(ActionEvent event) {
        
        Member member = new Member(tfname.getText(),tfid.getText(),tfmobile.getText(),tfemail.getText());
        tableview.getItems().add(member);
        tfname.setText(" ");
        tfid.setText(" ");
        tfmobile.setText(" ");
        tfemail.setText(" ");
    }

    @FXML
    private void SaveInfo(ActionEvent event) throws SQLException, ClassNotFoundException {
        
         String mname=tfname.getText();
        String mid=tfid.getText();
        String mmobile=tfmobile.getText();
        String memail=tfemail.getText();
        
        
        if(mname.isEmpty()|| mid.isEmpty() || mmobile.isEmpty()||memail.isEmpty()){
            
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Field Must Not Be Empty");
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
        
        
    }
    
    
    
     public static class Member{
        
        private  SimpleStringProperty name;
        private  SimpleStringProperty id;
        private  SimpleStringProperty mobile;
        private SimpleStringProperty email;
        
         Member(String name,String id,String mobile,String email){
            this.name= new SimpleStringProperty(name);
            this.id= new SimpleStringProperty(id);
            this.mobile= new SimpleStringProperty(mobile);
            this.email= new SimpleStringProperty(email);
            
            
        }

        public String getName() {
            return name.get();
        }

        public String getId() {
            return id.get();
        }

        public String getMobile() {
            return mobile.get();
        }

        public String getEmail() {
            return email.get();
        }
        
     }
    
}
