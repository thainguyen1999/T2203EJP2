package studentManage;


import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentDAO studentDao;

    public StudentManager() {
        studentDao = new StudentDAO();
        studentList = studentDao.read();
    }

    //thêm sv
    public void add() {
        String Id = inputId();
        String Name = inputName();
        String Address = inputAddress();
        int Phone = inputPhone();
        Student student = new Student(Id, Name, Address, Phone);
        studentList.add(student);
        studentDao.write(studentList);
    }


    public void show() {
        for (Student student : studentList) {
            System.out.println(student.getId() + " " + student.getName() + " " + student.getAddress() + " " + student.getPhone());
        }
    }

    public String inputId() {
        System.out.print("Nhập Id: ");
        return scanner.nextLine();
    }

    private String inputName() {
        System.out.print("Nhập tên: ");
        return scanner.nextLine();
    }

    private String inputAddress() {
        System.out.print("Nhập địa chỉ: ");
        return scanner.nextLine();
    }

    private int inputPhone() {
        System.out.print("Nhập sđt: ");
        return scanner.nextInt();
    }


    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
