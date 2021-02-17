/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueBook;

import BookList.BookListController;
import dba.DBConnection;
import View_IssueBook.Issue_BookController;
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
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class IssueBookController implements Initializable {

    /*@FXML
    private TableView<?> viewtable;
    @FXML
    private TableColumn<?, ?> bid;
    @FXML
    private TableColumn<?, ?> mid;
    @FXML
    private TableColumn<?, ?> issuetime;
    @FXML
    private TableColumn<?, ?> renewcount;*/

     @FXML
    private TableView<IssueBook> viewtable;
    @FXML
    private TableColumn<IssueBook, String> bid;
    @FXML
    private TableColumn<IssueBook, String> mid;
    @FXML
    private TableColumn<IssueBook, String> issuetime;
    @FXML
    private TableColumn<IssueBook, Integer> renewcount;
    
    private DBConnection connectDB;
     ObservableList<IssueBook> list=FXCollections.observableArrayList();
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            // TODO
            Init();
            connectDB =new DBConnection();
              try {
                  loadData();
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(IssueBookController.class.getName()).log(Level.SEVERE, null, ex);
              }
            } catch (SQLException ex) {
            Logger.getLogger(IssueBookController.class.getName()).log(Level.SEVERE, null, ex);
            
    }    
    
}

   public void Init() {
      viewtable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
            String MemberID=rs1.getString("MemberID");
            String IssueTime=rs1.getString("IssueTime");
                    int Renew_Count=rs1.getInt("Renew_Count");
            
            list.add(new IssueBook(Id,MemberID,IssueTime,Renew_Count));
        }
        }catch(SQLException ex){
            Logger.getLogger(IssueBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        viewtable.getItems().setAll(list);
        
    }  

    @FXML
    private void DeleteOp(ActionEvent event) throws SQLException, ClassNotFoundException {
        //viewtable.getItems().removeAll(viewtable.getSelectionModel().getSelectedItems());
        
        
     
     try{
       String sql="DELETE FROM Issue1";
       
    Connection conn;
           
        
             conn=DBConnection.projectconnection();
         
                 PreparedStatement pst=conn.prepareStatement(sql);
                 
                 pst.execute();
                
                 
                 Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                 alert1.setTitle("Issue1 Book");
                 alert1.setHeaderText(null);
                 alert1.setContentText("Issue1 Book Has Been Delete");
                 alert1.showAndWait();
       
    }
     catch (SQLException ex) {
               Logger.getLogger(IssueBookController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
     public static class IssueBook{
        
        private final  SimpleStringProperty Id;
        private final  SimpleStringProperty memid;
        private final  SimpleStringProperty issue;
        private final  SimpleIntegerProperty renew;

        public String getId() {
            return Id.get();
        }

        public String getMemberId() {
            return memid.get();
        }

        public String getIssueTime() {
            return issue.get();
        }

        public Integer getRenew_Count() {
            return renew.get();
        }
        
         IssueBook(String ID,String MemberID,String TimeIssue,Integer Renew_Count){
            this.Id= new SimpleStringProperty(ID);
            this.memid= new SimpleStringProperty(MemberID);
            this.issue= new SimpleStringProperty(TimeIssue);
            this.renew= new SimpleIntegerProperty(Renew_Count);
            
            
            
            
        }

}
}
