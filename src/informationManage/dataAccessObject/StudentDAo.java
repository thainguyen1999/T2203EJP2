package informationManage.dataAccessObject;


import informationManage.entities.Student;
import informationManage.helper.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAo implements DAOInterface<Student> {
    public static StudentDAo getInstance(){
        return new StudentDAo();
    }

    @Override
    public int insert(Student student) {
        try {
            String sql_txt="INSERT INTO students(id, name, email, sdt) VALUES('"+student.getId()+"','"+student.getFullName()+"','"+
                    student.getEmail()+"','"+student.getSdt()+"')";
            Connector conn=Connector.getInstance();
            PreparedStatement stt= conn.getPreparedStatement(sql_txt);
            stt.execute(sql_txt);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int update(Student student) {

        try {
            String sql_txt="UPDATE students SET name=?, email=?, sdt=? where id=?";

            Connector conn=Connector.getInstance();
            PreparedStatement stt= conn.getPreparedStatement(sql_txt);
            stt.setString(1,student.getId());
            stt.setString(2,student.getFullName());
            stt.setString(3, student.getEmail());
            stt.setString(4, String.valueOf(student.getSdt()));

            stt.execute();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(Student student) {

        try {
            String sql_txt="delete from students where id=?";
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getPreparedStatement(sql_txt);
            stt.setString(1, student.getId());
            stt.execute();
        }catch (Exception e){

        }
        return 0;
    }

    @Override
    public int findOne(Integer id) {
        String sql_txt="select * from students where id=?";
        try{
            Connector conn=Connector.getInstance();

            PreparedStatement stt= conn.getPreparedStatement(sql_txt);
            stt.setString(1,id.toString());
            stt.execute(sql_txt);
        }catch (Exception e){

        }
        return 0;
    }

    @Override
    public ArrayList<Student> selectAll() {
        ArrayList<Student>ls=new ArrayList<>();
        try {
            String sql_txt = "select * from students";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id= rs.getInt("id");
                String name=rs.getString("name");
                String email=rs.getString("email");
                int sdt= rs.getInt("sdt");
                Student st= new Student(id,name,email,sdt);
                ls.add(st);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return ls;
    }

    @Override
    public Student selectById(Student student) {
        return null;
    }

    @Override
    public ArrayList<Student> selectCondition(String condition) {
        return null;
    }
}
