package exss1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Manage {



    public void btnMember() throws Exception{
        Parent listMem= FXMLLoader.load(getClass().getResource("Member/member.fxml"));
        Main.rootStage.setScene(new Scene(listMem,800,600));
    }

    public void btnBook() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Book/book.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void btnBooks() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("BorrowBook/brBook.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }


}
