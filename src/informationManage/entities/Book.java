package informationManage.entities;

import informationManage.Main;
import informationManage.dataAccessObject.BookDAO;
import informationManage.library.Creat;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Book {
    public Integer id;
    public String name;
    public String author;
    public Integer qty;
    public Button editSt, deleteSt;

    public Book() {
    }

    public Book(Integer id, String name, String author, Integer qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.qty = qty;
        this.editSt=new Button("Edit");
        this.deleteSt=new Button("Delete");

        this.editSt.setOnAction((event)-> {
            try{
                FXMLLoader loader =new FXMLLoader(getClass().getResource("../library/Creat.fxml"));
                Parent root=loader.load();
                Creat cr=loader.getController();
                cr.setEditData(this);
                Main.rootStage.setScene(new Scene(root,800,600));
            }catch (Exception e){
                System.out.println(e.getMessage());

            }
        });
        this.deleteSt.setOnAction(event -> {
            BookDAO sd=new BookDAO();
            sd.delete(this);
        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Button getEditSt() {
        return editSt;
    }

    public void setEditSt(Button editSt) {
        this.editSt = editSt;
    }

    public Button getDeleteSt() {
        return deleteSt;
    }

    public void setDeleteSt(Button deleteSt) {
        this.deleteSt = deleteSt;
    }

    @Override
    public String toString() {
        return getName();
    }
}
