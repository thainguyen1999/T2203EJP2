package exss1.Member;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Date;

public class FormMember {
    public TextField inputIdMem;
    public TextField inputFullname;
    public TextField inputBirth;
    public TextField inputSex;
    public TextArea inputAdd;
    public Text errorMsg;
    private final exss1.Main Main;
    public Member editData;

    public FormMember(exss1.Main main) {
        Main = main;
    }

    public void setEditData(Member editData) {
        this.editData = editData;
        this.inputIdMem.setText(editData.getMaTV());
        this.inputFullname.setText(editData.getHoTen());
        this.inputBirth.setText(editData.getNgaySinh().toString());
        this.inputSex.setText(editData.getGioiTinh().toString());
        this.inputAdd.setText(editData.getDiaChi());
        this.inputIdMem.setDisable(true);
    }

    public void btnSub(ActionEvent actionEvent) {
        String ma = this.inputIdMem.getText();
        String name = this.inputFullname.getText();
        String date = this.inputBirth.getText();
        String gender = this.inputSex.getText();
        String address = this.inputAdd.getText();
        try {
            if (ma.isEmpty() || name.isEmpty() || date.equals("")  || gender.equals("") || address.isEmpty()){
                throw new Exception("Please enter full product information!");
            }

            MemberResponsitory mr = new MemberResponsitory();
            if(this.editData == null){ //nếu input rỗng thì add
                Member s = new Member(ma, name, Date.valueOf(date), Integer.parseInt(gender),address);
                mr.create(s);
            } else {    //edit
                mr.update(this.editData);
            }

            //dữ liệu đổ vào assigment01.database, từ assigment01.database tiếp tục đổ ngược lại tbStudent
            ActionEvent ActionEventactionEvent;
            this.backList();  //tự động back lại nếu dữ liệu up lên và đổ về thành công

        } catch (NumberFormatException nf){
            errorMsg.setVisible(true);

            errorMsg.setText(nf.getMessage());
        }
        catch (Exception e) {
            errorMsg.setVisible(true);

            errorMsg.setText(e.getMessage());
        }
    }

    private void backList() {
    }



    public void backList (ActionEvent actionEvent) throws  Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../member.fxml"));
        Main.rootStage.setScene(new Scene(root, 1100, 650));
    }


}
