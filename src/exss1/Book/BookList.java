package exss1.Book;

import exss1.entities.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static java.lang.Class.forName;

public class BookList implements Initializable {

    public  TableView<Book> tbBook;
    public TableColumn<Book, Integer> id;
    public TableColumn<Book, String> Author;
    public TableColumn<Book, String> name;
    public TableColumn<Book, Integer> Qty;
    public final static String connectionString="jdbc:mysql://localhost:3306/t2203e";
    public final static String user="root";
    public final static String pwd=""; //nếu là xampp"", map"root"
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("Author"));
        id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("Qty"));

        ObservableList<Book> ls = FXCollections.observableArrayList();
        //lấy data from database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection(connectionString,user,pwd);
            Statement statement= conn.createStatement();
            String sql_txt="select * from books";
            ResultSet rs= statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name= rs.getString("name");
                String Author= rs.getString("author");
                int qty= rs.getInt("qty");
                Book b= new Book(id, name,Author,qty);
                ls.add(b);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            tbBook.setItems(ls);
        }

    }

    public void btnBack(ActionEvent actionEvent) {
    }

    public void btnAdd(ActionEvent actionEvent) {
    }
}
