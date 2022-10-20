package informationManage.dataAccessObject;


import informationManage.entities.Student;
import informationManage.helper.Connector;

import java.sql.PreparedStatement;
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
        return 0;
    }

    @Override
    public int delete(Student student) {
        return 0;
    }

    @Override
    public ArrayList<Student> selectAll() {
        return null;
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
