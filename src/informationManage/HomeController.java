package informationManage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;


public class HomeController {
    public void goToBookList(ActionEvent actionEvent) throws Exception {
        Parent listBook= FXMLLoader.load(getClass().getResource("library/booklist.fxml"));
        Main.rootStage.setTitle("quản lí sách");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void goToStudentList(ActionEvent actionEvent) throws IOException {
        Parent listStudent=FXMLLoader.load(getClass().getResource("student/studentList.fxml"));
        Main.rootStage.setTitle("quản lí sinh viên");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }

    public void goToRent(ActionEvent actionEvent) throws  Exception {
        Parent listStudent=FXMLLoader.load(getClass().getResource("rentsbook/rents.fxml"));
        Main.rootStage.setTitle("quản lí muon sach");
        Main.rootStage.setScene(new Scene(listStudent,800,600));

    }
}
