package informationManage.entities;

import informationManage.Main;
import informationManage.dataAccessObject.StudentDAo;
import informationManage.student.StudentForm;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class Student {
    public  Integer id;
    public  String fullName,email;
    public Integer sdt;
    public Button editSt, deleteSt;


    public Student(){

    }

    public Student(Integer id, String fullName, String email, Integer sdt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.sdt = sdt;
        this.editSt=new Button("Edit");
        this.deleteSt=new Button("Delete");

        this.editSt.setOnAction((event)-> {
            try{
                FXMLLoader loader =new FXMLLoader(getClass().getResource("../student/studentForm.fxml"));
                    Parent root=loader.load();
                    StudentForm studentForm=loader.getController();
                    studentForm.setEditData(this);
                    Main.rootStage.setScene(new Scene(root,800,600));
            }catch (Exception e){
                System.out.println(e.getMessage());

            }
        });
        this.deleteSt.setOnAction(event -> {
            StudentDAo sd=new StudentDAo();
            sd.delete(this);
        });
        }


    public String getId() {
        return String.valueOf(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSdt() {
        return sdt;
    }

    public void setSdt(Integer sdt) {
        this.sdt = sdt;
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
        return getFullName();
    }
}
