package crud.dao;

import java.util.List;

import crud.models.Book;

public interface BookDAO {

	public void save(Book p);
    
    public List<Book> list();
    
    public void delete(Book p);
    
    public void edit(Book p);
    
    public Book getBook(int id);
}
