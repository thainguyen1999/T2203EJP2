package exss1.Member;

import exss1.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    public String maTV;
    public String hoTen;
    public Date ngaySinh;
    public Integer gioiTinh;
    public String diaChi;
    public Button editSt, deleteSt;

    public Member(String maTV, String hoTen, Date ngaySinh, Integer gioiTinh, String diaChi) {
        this.maTV = maTV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.editSt =  new Button("Edit");
        this.deleteSt = new Button("Delete");
        this.editSt.addActionListener(event -> {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("formMember.fxml"));
                Parent root = loader.load();
                FormMember fm = loader.getController();    //gọi controller kèm giao diện
                fm.setEditData(this);
                Main.rootStage.setScene(new Scene(root,1100,650));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

        this.deleteSt.addActionListener(event -> {
            MemberResponsitory sr = new MemberResponsitory();
            sr.delete(this);
        });
    }

    public String getMaTV() {
        return maTV;
    }

    public void setMaTV(String maTV) {
        this.maTV = maTV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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
}

