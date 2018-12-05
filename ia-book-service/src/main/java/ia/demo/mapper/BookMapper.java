package ia.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import ia.demo.po.Book;

@Mapper
public interface BookMapper {

	@Select("select * from book where name=#{name}")
	public List<Book> getBooksByName(String name);

	@Select("select * from book where isbn=#{isbn}")
	public List<Book> getBookByIsbn(String isbn);
	
	@Insert("insert into book(name,isbn,price) values(#{name},#{isbn},#{price})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public void save(Book book);
	
	@Select("select * from book")
	public List<Book> getAll();
	
	@Delete("delete from book")
	public void deleteAll();
}
