package ia.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import ia.demo.po.Sub;

@Mapper
public interface SubMapper {

	@Select("select * from sub where user_id=#{userId}")
	public List<Sub> getSubByUserId(long userId);
	
	@Select("select * from sub where book_id=#{bookId}")
	public List<Sub> getSubByBookId(long bookId);
	
	@Insert("insert into sub(user_id,book_id,datetime) values(#{userId},#{bookId},#{datetime})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public void save(Sub booking);
	
	@Select("select * from sub")
	public List<Sub> getAll();
	
	@Delete("delete from sub where user_id=#{userId}")
	public void deleteByUserId(long userId);
	
	@Delete("delete from sub")
	public void deleteAll();
}
