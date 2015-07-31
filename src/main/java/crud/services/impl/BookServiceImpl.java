package crud.services.impl;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import crud.dao.BookDAO;
import crud.models.Book;
import crud.services.BookService;

@Service
public class BookServiceImpl implements BookService {

	public List<Book> getBooks() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		BookDAO bookDAO = context.getBean(BookDAO.class);

		List<Book> list = bookDAO.list();

		context.close();
		
		return list;
	}

}
