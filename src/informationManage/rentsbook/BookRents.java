package informationManage.rentsbook;

import informationManage.dataAccessObject.BookDAO;
import informationManage.dataAccessObject.StudentDAo;
import informationManage.entities.Book;
import informationManage.entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BookRents implements Initializable {
    public ComboBox<Book> cbBook;
    public ComboBox<Student> cbStudent;
    public DatePicker dpExpired;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StudentDAo sD= new StudentDAo();
        ObservableList<Student> ls= FXCollections.observableArrayList();
        ls.addAll(sD.selectAll());
        cbStudent.setItems(ls);

        BookDAO bd=new BookDAO();
        ObservableList<Book> ol=FXCollections.observableArrayList();
        ol.addAll(bd.selectAll());
        cbBook.setItems(ol);
    }

    public void submit(ActionEvent actionEvent) {
        Student selected = cbStudent.getSelectionModel().getSelectedItem();
        Book select = cbBook.getSelectionModel().getSelectedItem();
        LocalDate dp = dpExpired.getValue();
        System.out.println(selected.getFullName());
        System.out.println(dp);
        System.out.println(select.getName());

    }
}
