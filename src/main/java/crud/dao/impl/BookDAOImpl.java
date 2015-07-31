package crud.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import crud.dao.BookDAO;
import crud.models.Book;

public class BookDAOImpl implements BookDAO{

	private SessionFactory sessionFactory;
	 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public void save(Book b) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(b);
        tx.commit();
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Book> list() {
		Session session = this.sessionFactory.openSession();
        List<Book> bookList = session.createQuery("from Book").list();
        session.close();
        return bookList;
	}

	public void delete(Book p) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
        session.close();
	}

	public void edit(Book p) {
		
	}

	public Book getBook(int id) {
		Session session = this.sessionFactory.openSession();
        Book book = (Book)session.get(Book.class, id);
        session.close();
        return book;
	}

}
