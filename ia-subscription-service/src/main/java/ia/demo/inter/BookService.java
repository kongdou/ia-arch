package ia.demo.inter;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ia.demo.po.Book;

@FeignClient(name="ia-book-service",value="ia-book-service")
public interface BookService {

	@GetMapping(value="/book/getBookByIsbn")
	List<Book> getBookByIsbn(@RequestParam("isbn") String isbn);

	@GetMapping(value="/book/getBookByName")
	List<Book> getBookByName(@RequestParam("name") String name);
}
