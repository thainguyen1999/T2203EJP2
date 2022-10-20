package exss1.entities;

public class Book {
    public Integer Id;
    public String name;
    public String Author;
    public Integer Qty;
     public Book(){

     }

    public Book(Integer id, String name, String author, Integer qty) {
        Id = id;
        this.name = name;
        Author = author;
        Qty = qty;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }
}
