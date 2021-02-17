
package library.system;

import BookList.BookListController;
import dba.DBConnection;
//import dba.DatabaseHandler;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class LibraryController implements Initializable {

    @FXML
    private TextField bookid;
    @FXML
    private Label bookname;
    @FXML
    private Label bookauthor;
    private DBConnection connectDB;
    @FXML
    private TextField memberid;
    @FXML
    private Label memName;
    @FXML
    private Label contact;
    //@FXML
    //private VBox listview;
    @FXML
    private TextField bookId;
    @FXML
    private StackPane rootPane;
    
    Boolean isSubmission=false;
    @FXML
    private ListView<String> listview;
   // DatabaseHandler databasehandler;
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connectDB= new DBConnection();
        //databasehandler =new DatabaseHandler();
        
    } 
@FXML
    private void addBook(ActionEvent event) throws IOException {
      loadWindow("/AddBook/AddBook.fxml","Add Book","/img/icons8-book-64.png"); 
    }
    
     @FXML
    private void addMember(ActionEvent event) throws IOException {
        loadWindow("/AddMember/AddMember.fxml","Add Member","/img/addmember.png");
        
    }
    
     @FXML
    private void listBook(ActionEvent event) throws IOException {
        loadWindow("/BookList/BookList.fxml","Book List","/img/view book.png");
    }

   @FXML
    private void listMember(ActionEvent event) throws IOException {
        loadWindow("/MemberList/MemberList.fxml","Member List","/img/viewmembers.png");
    }
        @FXML
   private void Issue_Book(ActionEvent event) throws IOException {
         loadWindows("/IssueBook/IssueBook.fxml","Issue Book"); 
    
    }
    public void loadWindow(String location,String title,String iconPath) throws IOException{
      
       Parent root=FXMLLoader.load(getClass().getResource(location)) ;
        Stage stage=new Stage(StageStyle.DECORATED);
        stage.setTitle(title);
        Image icon=new Image(getClass().getResourceAsStream(iconPath));
        stage.getIcons().add(icon);
        stage.setScene(new Scene(root));
        stage.show();
        
        
    }
      public void loadWindows(String location,String title) throws IOException{
      
       Parent root=FXMLLoader.load(getClass().getResource(location)) ;
        Stage stage=new Stage(StageStyle.DECORATED);
        stage.setTitle(title);
       // Image icon=new Image(getClass().getResourceAsStream(iconPath));
        //stage.getIcons().add(icon);
        stage.setScene(new Scene(root));
        stage.show();
        
        
    }


    @FXML
    private void bookidInter(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id=bookId.getText();
        String sql="SELECT *FROM tb_addBook where Id ='"+ id +"'";
        Connection con;
                con=DBConnection.projectconnection();
        PreparedStatement pst1=con.prepareStatement(sql);
        ResultSet rst1=pst1.executeQuery();
        
        boolean flag=false;
        
        while(rst1.next()){
            String bname=rst1.getString("title");
            String bauthor=rst1.getString("author");
            
            
            bookname.setText(bname);
            bookauthor.setText(bauthor);
           
            
            flag=true;
        }
        if(!flag){
            bookname.setText("No Such Book Is Available");
            bookauthor.setText("No Such Author Is Available");
        }
        }
       
        
    

    @FXML
    private void memberInter(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id=memberid.getText();
        String sql="SELECT *FROM AddMember WHERE MemberID='"+id+"'";
        Connection conn=DBConnection.projectconnection();
        PreparedStatement pst=conn.prepareStatement(sql);
        ResultSet rst=pst.executeQuery();
        boolean flag=false;
        
        while(rst.next()){
            String bmember=rst.getString("name");
            String binfo=rst.getString("mobile");
            
            memName.setText(bmember);
            contact.setText(binfo);
            flag=true;
        }
        if(!flag){
            memName.setText("No Such Member Is Available");
            contact.setText("No Such Contact Is Available");
        }
        
    }

    @FXML
    private void IssueBook(ActionEvent event) throws SQLException, ClassNotFoundException {
        String memberID=memberid.getText();
        String bookID=bookId.getText();
          
       
        Alert alert=new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Issue1 Operation");
        alert.setHeaderText(null);
        alert.setContentText("Are You Sure To Issue1 The Book "+bookname.getText()+" \n To "+memName.getText());
        Optional<ButtonType>response=alert.showAndWait();
        
        if(response.get()==ButtonType.OK){
            String sql="INSERT INTO Issue1(Id,MemberID)values(?,?)";
            Connection conn;
            try{
                conn=DBConnection.projectconnection();
                 PreparedStatement pst=conn.prepareStatement(sql);
                 pst.setString(1,bookID);
                 pst.setString(2,memberID);
                 pst.execute();
                 
                 Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);
                 alert1.setHeaderText(null);
                 alert1.setContentText("Book Issued Successfully To "+memName.getText());
                 alert1.showAndWait();
                 isSubmission=true;
            }
            catch(SQLException ex){
                 Alert alert3=new Alert(Alert.AlertType.ERROR);
                 alert3.setHeaderText(null);
                 alert3.setContentText("Please Enter The Information");
                 alert3.showAndWait();
                
                
                
                //Logger.getLogger(BookListController.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        }
    
    @FXML
    private void loadInfo(ActionEvent event) throws SQLException, ClassNotFoundException {
         
       /* ObservableList<String> issueData=FXCollections.observableArrayList();
        //isReadyForSubmission=true;
        try{
        String id=bookId.getText();
        
        
        String sql="SELECT  Issue_Book.Id,Issue_Book.MemberId,Issue_Book.IssueTime,Issue_Book.Renew_Count,\n"
                + "AddMember.Name,AddMember.MemberID,AddMember.Mobile,AddMember.Email,\n"
                + "tb_addBook.Title,tb_addBook.Id,tb_addBook.Author,tb_addBook.Publisher\n"
                + "from Issue_Book\n"
                + "LEFT JOIN AddMember\n"
                + "ON Issue_Book.MemberId=AddMember.MemberId\n"
                + "LEFT JOIN tb_addBook\n"
                + "ON Issue_Book.Id=tb_addBook.Id\n"
                + "WHERE Issue_Book.Id='" + id + "'";
        
        Connection conn=ConnectDB.getConnections();
            PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            
            while(rst.next())
            {
                mname.setText(rst.getString("Name"));
                mmobile.setText(rst.getString("Mobile"));
                memail.setText(rst.getString("Email"));
                
                bname.setText(rst.getString("Title"));
                bauthor.setText(rst.getString("Author"));
                bpublisher.setText(rst.getString("Publisher"));
                
                   //int renew_count=rst.getInt("");
                 mid.setText(rst.getString("MemberId"));
                time.setText(rst.getString("IssueTime"));
                //count.rst.getText("+renew_count");
             
              
        
                
                //isReadyForSubmission=true;
            }
        }
        catch(SQLException e){
        }
        //listview.getItems().setAll(issueData);
        
        
        */
        
        
        
        
        
        ObservableList<String> issueData=FXCollections.observableArrayList();
        //isReadyForSubmission=true;
        String id=bookId.getText();
        
        String sql="SELECT * FROM Issue1 WHERE id='"+ id+"'";
         Connection conn;
        try {
            conn = DBConnection.projectconnection();
            PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            
            while(rst.next()){
                String bookID=id;
                String memberID=rst.getString("memberID");
                String issueTime=rst.getString("issueTime");
                
                int renew_count=rst.getInt("Renew_Count");
                
                issueData.add("Issued Information:");
                issueData.add("      Issued Time And Date :  "+issueTime);
                issueData.add("      Renew Count:  "+renew_count);
                
                issueData.add("Book Information:");
                String sql2="SELECT * FROM tb_addBook WHERE id='"+bookID+"'";
                Connection con2=DBConnection.projectconnection();
                PreparedStatement pst2=conn.prepareStatement(sql2);
                
                 ResultSet rst2=pst2.executeQuery();
                 
                 while(rst2.next()){
                     issueData.add("      Book Name :  "+rst2.getString("Title"));
                     issueData.add("      Book ID :  "+rst2.getString("Id"));
                     issueData.add("      Book Author :  "+rst2.getString("Author"));
                     issueData.add("      Book Publisher :  "+rst2.getString("Publisher"));
                     
                 }
                 issueData.add("Member Information:");
                 String sql3="SELECT * FROM AddMember WHERE MemberID='"+memberID+"'";
                  Connection con3=DBConnection.projectconnection();
                PreparedStatement pst3=conn.prepareStatement(sql3);
                
                 ResultSet rst3=pst3.executeQuery();
                 
                 while(rst3.next()){
                     issueData.add("       Member Name :  "+rst3.getString("Name"));
                     issueData.add("       Member ID :  "+rst3.getString("MemberID"));
                     issueData.add("       Member Mobile :  "+rst3.getString("Mobile"));
                     issueData.add("       Member Email :  "+rst3.getString("Email"));
                     
            }
            
            //isReadyForSubmission=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        listview.getItems().setAll(issueData);
    }

    @FXML
    private void Menu_Close(ActionEvent event) {
        close();
    }
    

 
      void close() {
        ((Stage)rootPane.getScene().getWindow()).close();
    
    }

    @FXML
    private void Add_Book(ActionEvent event) throws IOException {
         loadWindow("/AddBook/AddBook.fxml","Add Book","/img/icons8-book-64.png"); 
    
    }

    @FXML
    private void Add_Member(ActionEvent event) throws IOException {
         loadWindow("/AddMember/AddMember.fxml","Add Member","/img/addmember.png");
        
    }

    @FXML
    private void View_Book(ActionEvent event) throws IOException {
        loadWindow("/BookList/BookList.fxml","Book List","/img/view book.png");
     
    }

    @FXML
    private void View_Member(ActionEvent event) throws IOException {
        loadWindow("/MemberList/MemberList.fxml","Member List","/img/viewmembers.png");
     
    }
  


    @FXML
    private void Full_Screen(ActionEvent event) {
        Stage stage=((Stage)rootPane.getScene().getWindow());
        stage.setFullScreen(true);
    }

    @FXML
    private void Submission_Book(ActionEvent event) throws SQLException, ClassNotFoundException {
        isSubmission=true;
  
       if(!isSubmission) {
        Alert alert=new Alert(Alert.AlertType.ERROR);
                 alert.setHeaderText(null);
                 alert.setContentText("Please select a book to submission");
                 alert.showAndWait();
    }
       String id=bookId.getText();
       String sql="DELETE FROM Issue1 WHERE Id='"+ id+"'";
       
    Connection conn;
           
                conn=DBConnection.projectconnection();
                 PreparedStatement pst=conn.prepareStatement(sql);
                 
                 pst.execute();
                
                 
                 Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                 alert1.setTitle("Submission Book");
                 alert1.setHeaderText(null);
                 alert1.setContentText("Book Has Been Submitted");
                 alert1.showAndWait();
       
    }

    @FXML
    private void Renew_Book(ActionEvent event) throws SQLException, ClassNotFoundException {
           /* while(!isReadyForSubmission) {
        Alert alert=new Alert(Alert.AlertType.ERROR);
                 alert.setHeaderText(null);
                 alert.setContentText("Please select a book to Renew");
                 alert.showAndWait();
            }    
        Alert alert=new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Renew Operation");
        alert.setHeaderText(null);
        alert.setContentText("Are You Sure Want To Renew The Book ?");
        Optional<ButtonType>response=alert.showAndWait();
        if(response.get()==ButtonType.OK){
            String sql="UPDATE Issue_Book SET Renew_Count=Renew_Count+1 WHERE Id='" +bookId.getText()+"'";
             Connection conn;
           
                conn=ConnectDB.getConnections();
                 PreparedStatement pst=conn.prepareStatement(sql);
                 pst.execute();
            Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                 alert1.setHeaderText(null);
                 alert1.setContentText("Book Has Been Renew");
                 alert1.showAndWait();
        }*/
                
        try {
            
                 String sql =  "UPDATE Issue1 SET IssueTime=CURRENT_TIMESTAMP, Renew_Count = Renew_Count+1 WHERE Id = '" + bookId.getText() + "'"; 
                Connection conn = DBConnection.projectconnection();
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                
             Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Renew Book");
            alert1.setHeaderText(null);
            alert1.setContentText("Renew Book Operation Successd");
            alert1.showAndWait();
            } catch (SQLException ex) {
               Logger.getLogger(LibraryController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
    }



  
}



   
   
   

