package ia.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ia.demo.inter.BookService;
import ia.demo.inter.UserService;
import ia.demo.po.Book;
import ia.demo.po.Sub;
import ia.demo.po.User;
import ia.demo.service.SubService;

@RestController
@RequestMapping("/subscription")
public class SubController {

	@Autowired
	private SubService subService;

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/subbook", method = RequestMethod.POST)
	public String subBook(@RequestParam("username") String username, @RequestParam("bookname") String bookname) {
		Sub sub = new Sub();
		// 查询UserID
		List<User> users = userService.getUserByName(username);
		if (users != null && users.size() > 0) {
			sub.setUserId(users.get(0).getId());
		}
		// 查询BookID
		List<Book> books = bookService.getBookByName(bookname);
		if (books != null && books.size() > 0) {
			sub.setBookId(books.get(0).getId());
		}

		sub.setDatetime(new Date());
		subService.saveSub(sub);
		return "success";
	}

	/**
	 * 通过用户名查询该用户的预订情况
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/getSubByUserName", method = RequestMethod.GET)
	public List<Sub> getSubByUserName(@RequestParam("username") String username) {
		List<Sub> subs = new ArrayList<Sub>();
		// 查询UserID
		List<User> users = userService.getUserByName(username);
		if (users != null && users.size() > 0) {
			subs = subService.getSubByUserId(users.get(0).getId());
		}
		return subs;
	}

	/**
	 * 查看某本书的预订情况
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/getSubByBookName", method = RequestMethod.GET)
	public List<Sub> getSubByBookName(@RequestParam("name") String name) {
		List<Sub> subs = new ArrayList<Sub>();
		// 查询BookID
		List<Book> books = bookService.getBookByName(name);
		if (books != null && books.size() > 0) {
			subs = subService.getSubByBookId(books.get(0).getId());
		}
		return subs;
	}

	/**
	 * 查看某本书的预订情况
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/deleteSubByUserName", method = RequestMethod.DELETE)
	public String deleteSubByUserName(@RequestParam("username") String username) {

		// 查询UserID
		List<User> users = userService.getUserByName(username);
		if (users != null && users.size() > 0) {
			subService.deleteByUserId(users.get(0).getId());
			return "delete success";
		}
		return "no record deleted";
	}

}
