package ia.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import ia.demo.po.User;

@Mapper
public interface UserMapper {

	@Select("select * from user where username=#{name}")
	public List<User> getUserByName(String name);
	
	@Insert("insert into user(username,age,email) values(#{username},#{age},#{email})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public void save(User user);
	
	@Select("select * from user")
	public List<User> getAll();
	
	@Delete("delete from user")
	public void deleteAll();
}
