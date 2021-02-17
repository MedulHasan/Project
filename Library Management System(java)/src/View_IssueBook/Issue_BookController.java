/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_IssueBook;

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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class Issue_BookController implements Initializable {

    @FXML
    private TableView<Issue_Book> viewtable;
    @FXML
    private TableColumn<Issue_Book, String> bid;
    @FXML
    private TableColumn<Issue_Book, String> mid;
    @FXML
    private TableColumn<Issue_Book, String> issuetime;
    @FXML
    private TableColumn<Issue_Book, Integer> renewcount;

    private DBConnection connectDB;
     ObservableList<Issue_Book> list=FXCollections.observableArrayList();
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
            try {
            // TODO
            Init();
            connectDB =new DBConnection();
                try {
                    loadData();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Issue_BookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
            Logger.getLogger(Issue_BookController.class.getName()).log(Level.SEVERE, null, ex);
            }
      
    }
    

   public void Init() {
      
        bid.setCellValueFactory(new PropertyValueFactory<>("Id"));
        mid.setCellValueFactory(new PropertyValueFactory<>("MemberId"));
        issuetime.setCellValueFactory(new PropertyValueFactory<>("IssueTime"));
        renewcount.setCellValueFactory(new PropertyValueFactory<>("Renew_Count"));
    }
  public void loadData() throws SQLException, ClassNotFoundException{
        String sql5="SELECT * FROM Issue1";
        Connection con;
        try{
                
                con=DBConnection.projectconnection();
        PreparedStatement pst=con.prepareStatement(sql5);
        ResultSet rs1=pst.executeQuery();
        while(rs1.next()){
            String Id=rs1.getString("Id");
            String memid=rs1.getString("MemberId");
            String issue=rs1.getString("IssueTime");
                    int renew=rs1.getInt("Renew Count");
            
            list.add(new Issue_Book(Id,memid,issue,renew));
        }
        }catch(SQLException ex){
            Logger.getLogger(BookListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        viewtable.getItems().setAll(list);
        
    }  
    
     public static class Issue_Book{
        
        private  SimpleStringProperty Id;
        private  SimpleStringProperty memid;
        private  SimpleStringProperty issue;
        private  SimpleIntegerProperty renew;

        public String getId() {
            return Id.get();
        }

        public String getMemid() {
            return memid.get();
        }

        public String getIssue() {
            return issue.get();
        }

        public Integer getRenew() {
            return renew.get();
        }
        
        public Issue_Book(String ID,String memid,String time,Integer count){
            this.Id= new SimpleStringProperty(ID);
            this.memid= new SimpleStringProperty(memid);
            this.issue= new SimpleStringProperty(time);
            this.renew= new SimpleIntegerProperty(count);
            
            
            
            
        }

}
}


