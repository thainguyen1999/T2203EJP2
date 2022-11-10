package studentManage;

import java.io.Serializable;

public class Student implements Serializable {
    public String Id;
    public String Name;
    public String Address;
    public String Phone;

    public Student(){
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Student(String id, String name, String address, String phone) {
        Id = id;
        Name = name;
        Address = address;
        Phone = phone;
    }

}