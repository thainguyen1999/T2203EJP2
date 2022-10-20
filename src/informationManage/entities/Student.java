package informationManage.entities;

public class Student {
    public  Integer id;
    public  String fullName,email;
    public Integer sdt;


    public Student(String name, String email, Integer integer){

    }

    public Student(Integer id, String fullName, String email, Integer sdt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.sdt = sdt;
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
}
