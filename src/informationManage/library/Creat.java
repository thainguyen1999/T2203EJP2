package informationManage.library;

import informationManage.Main;
import informationManage.entities.Book;
import informationManage.entities.Student;
import informationManage.helper.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class Creat {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;
    public Book editData;
    public  void setEditData(Book editData){
        this.editData = editData;

        this.txtName.setText(editData.getName());
        this.txtAuthor.setText(editData.getAuthor());
        this.txtQty.setText(String.valueOf(editData.getQty()));
}

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            String sql_txt = "insert into books(name,author,qty) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(name);
            arr.add(author);
            arr.add(qty);
            if(conn.execute(sql_txt,arr)){
                backToList();
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void backToList() throws Exception {
        Parent creat= FXMLLoader.load(getClass().getResource("booklist.fxml"));
        Main.rootStage.setTitle("thêm sách");
        Main.rootStage.setScene(new Scene(creat,800,600));
    }
}
