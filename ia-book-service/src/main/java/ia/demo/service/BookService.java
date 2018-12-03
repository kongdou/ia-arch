package ia.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import ia.demo.mapper.BookMapper;
import ia.demo.po.Book;

@Service
public class BookService {

	@Autowired
	BookMapper bookMapper;
	
	public List<Book> getBooksByUserId(long id){
        return bookMapper.getBooksByUserId(id);
    }
	
	public void save(Book book){
		bookMapper.save(book);
    }
	
	public List<Book> getAll(int pageNum,int pageSize)throws Exception{
		PageHelper.startPage(pageNum,pageSize);
		return bookMapper.getAll();
	}
	
	public void deleteAll() {
		bookMapper.deleteAll();
	}
	
	
	
}
