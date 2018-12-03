package ia.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ia.demo.po.User;
import ia.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/getUserByName",method=RequestMethod.GET)
	public List<User> getByGradeName(@RequestParam("name") String name){
		return userService.getUserByName(name);
	}
	
	@RequestMapping(value="/add")
	public String add() {
		User user = new User();
		//20-30随机数
		user.setAge(new Random().nextInt(10)+20);
		String username = randonName(8);
		user.setEmail(username+"@gmail.com");
		user.setUsername(username);
		userService.save(user);
		return "success";
	}
	
	/**
	 * 随机len位英文字母名称，测试使用
	 * @return
	 */
	private static String randonName(int len) {
		String str = "";
        for (int i = 0;i<len;i++){
            str = str+ (char)(Math.random()*26+'a');
        }
        return str;
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<User> getAll(@RequestParam("num") int pageNum,@RequestParam("size") int pageSize) {
		try {
			return userService.getAll(pageNum, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/delAll",method=RequestMethod.GET)
	public String delete() {
		try {
		 userService.deleteAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
}
