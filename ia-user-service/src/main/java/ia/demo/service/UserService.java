package ia.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import ia.demo.mapper.UserMapper;
import ia.demo.po.User;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public List<User> getUserByName(String name){
        return userMapper.getUserByName(name);
    }
	
	public void save(User user){
		userMapper.save(user);
    }
	
	public List<User> getAll(int pageNum,int pageSize)throws Exception{
		PageHelper.startPage(pageNum,pageSize);
		return userMapper.getAll();
	}
	
	public void deleteAll() {
		userMapper.deleteAll();
	}
	
}
