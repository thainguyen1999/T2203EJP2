package informationManage.entities;

import informationManage.dataAccessObject.BookDAO;

import javax.xml.crypto.Data;
import java.util.Date;

public class BookRents {
    private Integer id;
    private Integer bookId;
    private Integer studentId;
    private Date rentDate;
    private Date expiredDate;
    private Integer status;
    public Book book;


    public BookRents(Integer id, Integer bookId, Integer studentId, Data rentDate, Data expiredDate, Integer status) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.rentDate = (Date) rentDate;
        this.expiredDate = (Date) expiredDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public int book(){
            BookDAO bd=new BookDAO();
            int b=bd.findOne(this.bookId);
            return b;
            //return(BookDao) RepositoryFactory.createRepository(RepoType.BOOK)).findOne(this.getBookId());
    }
}
