package informationManage.student;

import informationManage.Main;
import informationManage.entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StudentList implements Initializable {
    public TableView<Student> tbStudent;
    public TableColumn<Student,Integer> idSt;
    public TableColumn<Student,String> nameSt;
    public TableColumn<Student,String> emailSt;
    public TableColumn<Student,Integer> sdtSt;
    public TableColumn<Student, Button> edit;
    public TableColumn <Student, Button>del;

    public final static String connectionString = "jdbc:mysql://localhost:3306/t2203e";
    public final static String user = "root";
    public final static String pwd = "";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idSt.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        nameSt.setCellValueFactory(new PropertyValueFactory<Student,String>("fullName"));
        emailSt.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        sdtSt.setCellValueFactory(new PropertyValueFactory<Student,Integer>("sdt"));
        edit.setCellValueFactory(new PropertyValueFactory<Student,Button>("editSt"));
        del.setCellValueFactory(new PropertyValueFactory<Student,Button>("deleteSt"));
        ObservableList<Student> student= FXCollections.observableArrayList();


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(connectionString,user,pwd);
            Statement stt=con.createStatement();
            String sql="select * from students";
            ResultSet resultSet=stt.executeQuery(sql);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String fullName=resultSet.getString("name");
                String email=resultSet.getString("email");
                int sdt=resultSet.getInt("sdt");
                Student st=new Student(id,fullName,email,sdt);
                student.add(st);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudent.setItems(student);
        }

    }

    public void back(ActionEvent actionEvent) throws  Exception {
        Parent home= FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("home");
        Main.rootStage.setScene(new Scene(home,800,600));
    }

    public void add(ActionEvent actionEvent) throws Exception {
        Parent book=FXMLLoader.load(getClass().getResource("studentForm.fxml"));
        Main.rootStage.setScene(new Scene(book,800,600));
    }
}
