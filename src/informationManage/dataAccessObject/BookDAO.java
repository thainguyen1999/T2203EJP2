package informationManage.dataAccessObject;

import informationManage.entities.Book;
import informationManage.entities.Student;
import informationManage.helper.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO implements  DAOInterface<Book>{
    public static StudentDAo getInstance(){
        return new StudentDAo();
    }
    @Override
    public int insert(Book book) {
        try {
            String sql_txt="INSERT INTO books(id, name, author, qty) VALUES('"+book.getId()+"','"+book.getName()+"','"+
                    book.getAuthor()+"','"+book.getQty()+"')";
            Connector conn=Connector.getInstance();
            PreparedStatement stt= conn.getPreparedStatement(sql_txt);
            stt.execute(sql_txt);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return 0;
    }

    @Override
    public int update(Book book) {
        try{
        String sql_txt="UPDATE students SET name=?, email=?, sdt=? where id=?";

        Connector conn=Connector.getInstance();
        PreparedStatement stt= conn.getPreparedStatement(sql_txt);
        stt.setString(1, String.valueOf(book.getId()));
        stt.setString(2,book.getName());
        stt.setString(3, book.getAuthor());
        stt.setString(4, String.valueOf(book.getQty()));
        if (conn.execute(sql_txt, (ArrayList) stt)){
            return stt.getResultSetConcurrency();
        }
    }catch (Exception e){
        System.out.println(e.getMessage());
    }

        return 0;
    }

    @Override
    public int delete(Book book) {
        try {
            String sql_txt="delete from students where id=?";
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getPreparedStatement(sql_txt);
            stt.setString(1, String.valueOf(book.getId()));
            stt.execute();
        }catch (Exception e){

        }
        return 0;

    }

    @Override
    public int findOne(Book book) {
        return 0;
    }

    @Override
    public ArrayList<Book> selectAll() {
        ArrayList<Book>ls=new ArrayList<>();
        try{
            String sql_txt = "select * from students";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id= rs.getInt("id");
                String name=rs.getString("name");
                String author=rs.getString("author");
                int qty= rs.getInt("qty");
                Book st= new Book(id,name,author,qty);
                ls.add(st);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return ls;

    }

    @Override
    public Book selectById(Book book) {
        return null;
    }

    @Override
    public ArrayList<Book> selectCondition(String condition) {
        return null;
    }
}
