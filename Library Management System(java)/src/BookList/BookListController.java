/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookList;

import dba.DBConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;



public class BookListController implements Initializable {

   
    
    @FXML
    private TableColumn<Book, String> titlecol;
    @FXML
    private TableColumn<Book, String> idcol;
    @FXML
    private TableColumn<Book, String> authorcol;
    @FXML
    private TableColumn<Book, String> publishercol;
    
    private DBConnection connectDB;
    
    ObservableList<Book> list=FXCollections.observableArrayList();
    @FXML
    private TableView<Book> tableview;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tfauthor;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfpublisher;

    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
        connectDB =new DBConnection();
        try {
            try {
                loadData();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BookListController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
   
    public void initCol(){
        tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        titlecol.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        idcol.setCellValueFactory(new PropertyValueFactory<Book,String>("id"));
        authorcol.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        publishercol.setCellValueFactory(new PropertyValueFactory<Book,String>("publisher"));
        
        //tableview.setEditable(true);
        //titlecol.setCellFactory(TextFieldTableCell.forTableColumn());
    }
    public void loadData() throws SQLException, ClassNotFoundException{
        String sql="SELECT * FROM tb_addBook";
        Connection con;
        try{
                
                con=DBConnection.projectconnection();
        PreparedStatement pst=con.prepareStatement(sql);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            String title=rs.getString("title");
            String id=rs.getString("id");
            String author=rs.getString("author");
            String publisher=rs.getString("publisher");
            
            list.add(new Book(title,id,author,publisher));
        }
        }catch(SQLException ex){
            Logger.getLogger(BookListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableview.getItems().setAll(list);
        
    }

    @FXML
    private boolean DeleteOption(ActionEvent event) throws SQLException, ClassNotFoundException {
        Book selectedForDeletion=tableview.getSelectionModel().getSelectedItem();
        if(selectedForDeletion==null){
           
                     Alert alert=new Alert(Alert.AlertType.ERROR);
                 alert.setHeaderText(null);
                 alert.setContentText("Please select a book to Deletion");
                 alert.showAndWait();
        }
         Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting Book");
        alert.setHeaderText(null);
        alert.setContentText("Are You Sure To Delete The Book "+selectedForDeletion.getTitle()+"?");
        Optional<ButtonType>response=alert.showAndWait();
        if(response.get()==ButtonType.OK){
          /*  ObservableList<Book> selectedItem, allBooks;
        allBooks=tableview.getItems();
        selectedItem=tableview.getSelectionModel().getSelectedItems();
        selectedItem.forEach(allBooks::remove);*/
          String sql="DELETE FROM tb_addBook";
       
    Connection conn;
           
                conn=DBConnection.projectconnection();
                 PreparedStatement pst=conn.prepareStatement(sql);
                 
                 pst.execute();
                
                 
                 Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                 alert1.setTitle("Delete  Book");
                 alert1.setHeaderText(null);
                 alert1.setContentText("Book Has Been Delete");
                 alert1.showAndWait();
       
         // tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItems());
        }
        else{
             Alert alert2=new Alert(Alert.AlertType.ERROR);
                 alert.setHeaderText(null);
                 alert.setContentText("Deletion Cancelled");
                 alert.showAndWait();
        }
        return false;
    }

    @FXML
    private void DeleteOperation(ActionEvent event) throws SQLException {
        //Book book=tableview.getSelectionModel().getSelectedItem();
        //list.remove(book);
         //ObservableList<Book> selectedItems=FXCollections.observableArrayList();
        //selectedItems=tableview.getSelectionModel().getSelectedItems();
        //list.removeAll(selectedItems);
        /*ObservableList<Book> selectedItem, allBooks;
        allBooks=tableview.getItems();
        selectedItem=tableview.getSelectionModel().getSelectedItems();
        selectedItem.forEach(allBooks::remove);*/
        
   
       
       /*String sql="DELETE FROM tb_addBook ";
       
    Connection conn;
           
                conn=ConnectDB.getConnections();
                 PreparedStatement pst=conn.prepareStatement(sql);
                 
                 pst.execute();
                
                 
                 Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                 alert1.setTitle("Delete  Book");
                 alert1.setHeaderText(null);
                 alert1.setContentText("Book Has Been Delete");
                 alert1.showAndWait();*/
       
       
       
        
    }

    @FXML
    private void Showdata(ActionEvent event) {
        Book  book = new Book(tfname.getText(),tfid.getText(),tfauthor.getText(),tfpublisher.getText());
        tableview.getItems().add(book);
        tfname.setText(" "); 
            tfid.setText(" "); 
            tfauthor.setText(" "); 
            tfpublisher.setText(" ");
    }

    @FXML
    private void savedata(ActionEvent event) throws SQLException, ClassNotFoundException {
        String mtitle=tfname.getText();
        String mid=tfid.getText();
        String mauthor=tfauthor.getText();
        String mpublisher=tfpublisher.getText();
        
        
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
            /*tfname.setText(" "); 
            tfid.setText(" "); 
            tfauthor.setText(" "); 
            tfpublisher.setText(" "); */
            return;
        
    }

    @FXML
    private void onEditChanged(TableColumn.CellEditEvent<Book, String> event) {
         tableview.setEditable(true);
        titlecol.setCellFactory(TextFieldTableCell.forTableColumn());
        Book book=tableview.getSelectionModel().getSelectedItem();
      // book.settitle(event.getNewValue())
        
    }
    
    public static class Book{
        
        private final SimpleStringProperty title;
        private final SimpleStringProperty id;
        private final SimpleStringProperty author;
        private final SimpleStringProperty publisher;
        
       Book(String title,String id,String author,String publisher){
            this.title= new SimpleStringProperty(title);
            this.id= new SimpleStringProperty(id);
            this.author= new SimpleStringProperty(author);
            this.publisher= new SimpleStringProperty(publisher);
            
            
            
            
        }

        public String getTitle() {
            return title.get();
        }

        public String getId() {
            return id.get();
        }

        public String getAuthor() {
            return author.get();
        }

        public String getPublisher() {
            return publisher.get();
        }
        
        
        
    }



}    


