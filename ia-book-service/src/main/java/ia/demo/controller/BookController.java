package ia.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ia.demo.inter.UserService;
import ia.demo.po.Book;
import ia.demo.po.User;
import ia.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getbooks", method = RequestMethod.GET)
	public List<Book> getBooksByUserID(@RequestParam("id") long id) {
		return bookService.getBooksByUserId(id);
	}

	@RequestMapping(value="/addbook",method=RequestMethod.POST)
	public String add(@RequestParam("isbn") String isbn,@RequestParam("name") String bookname,
			@RequestParam("price") double price,@RequestParam("username") String username) {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setName(bookname);
		book.setPrice(price);
		//调用用户服务，通过username查询userid
		User user = userService.getUserByName(username).get(0);
		if(user != null ) {
			book.setUserId(user.getId());
		}
		bookService.save(book);
		return "success";
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Book> getAll(@RequestParam("num") int pageNum, @RequestParam("size") int pageSize) {
		try {
			return bookService.getAll(pageNum, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/delAll", method = RequestMethod.GET)
	public String delete() {
		try {
			bookService.deleteAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

}
