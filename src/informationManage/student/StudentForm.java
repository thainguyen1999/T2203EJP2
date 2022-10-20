package informationManage.student;

import informationManage.Main;
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

    public void AddSt(ActionEvent actionEvent) {
        try {
            String name =txtFullName.getText();
            String email=txtEmail.getText();
            Integer phoneNumber= Integer.parseInt(txtPhone.getText());
            String sql="insert into students(name, email, sdt) values(?,?,?) ";
            Connector con=Connector.getInstance();
            ArrayList arrayList= new ArrayList();
            arrayList.add(name);
            arrayList.add(email);
            arrayList.add(phoneNumber);
            if (con.execute(sql,arrayList)){
                backToList();
            }else {
                System.out.println("error");
            }

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
