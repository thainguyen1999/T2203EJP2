package informationManage.library;

import informationManage.Main;
import informationManage.entities.Book;
import informationManage.entities.Student;
import informationManage.helper.Connector;
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


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.ResourceBundle;

public class BookList implements Initializable {

    public TableColumn<Book, Integer> tdId;
    public TableColumn<Book,String> tdName;
    public TableColumn<Book,String> tdAuthor;
    public TableColumn<Book,Integer> tdQty;
    public TableColumn<Book, Button> edit;
    public TableColumn<Book,Button> del;
    public TableView<Book> tbBook;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Book,Integer>("qty"));
        edit.setCellValueFactory(new PropertyValueFactory<Book,Button>("editSt"));
        del.setCellValueFactory(new  PropertyValueFactory<Book,Button>("deleteSt"));
        ObservableList<Book> ls = FXCollections.observableArrayList();

        try {

            String sql_txt="select* from books";
            Connector conn=  Connector.getInstance();
            ResultSet rs=conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                Book b = new Book(id,name,author,qty);
                ls.add(b);
            }

        }catch (Exception e){

        }finally {
          tbBook.setItems(ls);
        }

    }


    public void creat(ActionEvent actionEvent) throws IOException{
       Parent book=FXMLLoader.load(getClass().getResource("Creat.fxml"));
        Main.rootStage.setScene(new Scene(book,800,600));
    }

    public void back() throws IOException{
        Parent home= FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("home");
        Main.rootStage.setScene(new Scene(home,800,600));
    }
}
