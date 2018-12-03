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

	@Select("select * from book where userid=#{id}")
	public List<Book> getBooksByUserId(long id);
	
	@Insert("insert into book(user_id,name,isbn) values(#{userId},#{name},#{isbn})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public void save(Book book);
	
	@Select("select * from book")
	public List<Book> getAll();
	
	@Delete("delete from book")
	public void deleteAll();
}
