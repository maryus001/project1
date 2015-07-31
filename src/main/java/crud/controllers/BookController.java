package crud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import crud.dao.BookDAO;
import crud.models.Book;
import crud.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/welcome")
	public ModelAndView index() {
		List<Book> books = bookService.getBooks();

		return new ModelAndView("list", "bookList", books);
	}

	@RequestMapping("/webservice")
	public @ResponseBody Map<String, Integer> returnJson() {
		Map<String, Integer> hm = new HashMap();
		hm.put("Zara", 1);
		hm.put("Mahnaz", 2);
		hm.put("Ayan", 3);
		hm.put("Daisy", 4);
		hm.put("Qadir", 5);

		return hm;
	}

	@RequestMapping("/admin")
	public ModelAndView adminPg() {
		return new ModelAndView("admin");
	}

	@RequestMapping("/superadmin")
	public ModelAndView superAdminPg() {
		return new ModelAndView("superadmin");
	}

	@RequestMapping("/addBook")
	public ModelAndView addBook(@RequestParam String title) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		BookDAO bookDAO = context.getBean(BookDAO.class);

		Book book = new Book();
		book.setTitle(title);

		bookDAO.save(book);

		context.close();

		return new ModelAndView("redirect:welcome");
	}

	@RequestMapping("/editBook")
	public ModelAndView editBook(@RequestParam int id,
			@RequestParam String title) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		BookDAO bookDAO = context.getBean(BookDAO.class);

		Book book = new Book();
		book.setTitle(title);

		bookDAO.save(book);

		context.close();

		return new ModelAndView("redirect:welcome");
	}

	@RequestMapping("/deleteBook")
	public ModelAndView deleteBook(@RequestParam int id) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		BookDAO bookDAO = context.getBean(BookDAO.class);

		Book book = bookDAO.getBook(id);
		bookDAO.delete(book);

		context.close();

		return new ModelAndView("redirect:welcome");
	}
}