package studentManage;

import java.io.Serializable;

public class Student implements Serializable {
    public String Id;
    public String Name;
    public String Address;
    public int Phone;

    public Student(){
    }

    public Student(String id, String name, String address, int phone) {
        Id = id;
        Name = name;
        Address = address;
        Phone = phone;
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

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }



}