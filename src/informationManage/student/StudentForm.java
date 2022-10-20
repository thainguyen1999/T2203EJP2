package informationManage.student;

import informationManage.Main;
import informationManage.dataAccessObject.StudentDAo;
import informationManage.entities.Student;
import informationManage.helper.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class StudentForm {
    public TextField txtFullName;
    public TextField txtEmail;
    public TextField txtPhone;
    public Student editData;
    public TextField id;

    public  void setEditData(Student editData){
        this.editData = editData;
        this.id.setText(editData.getId());
        this.txtEmail.setText(editData.getEmail());
        this.txtFullName.setText(editData.getFullName());
        this.txtPhone.setText(String.valueOf(editData.getSdt()));
    }

    public void AddSt(ActionEvent actionEvent)  {
        String code=this.id.getText();
        String name=this.txtFullName.getText();
        String email=this.txtEmail.getText();
        String phoneNumber=this.txtPhone.getText();
        try {

            if(code.isEmpty()|| name.isEmpty() ||email.isEmpty()|| phoneNumber.isEmpty()){
                throw new Exception("please enter full product information");
            }
            StudentDAo studentDAo=new StudentDAo();
            if (this.editData==null){
                Student st=new Student(Integer.valueOf(code),name,email,Integer.valueOf(phoneNumber));
                studentDAo.insert(st);

            }
            this.backToList();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void backToList() throws  Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("studentList.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }
}
