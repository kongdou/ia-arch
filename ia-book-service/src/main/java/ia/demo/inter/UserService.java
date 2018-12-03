package ia.demo.inter;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ia.demo.po.User;

@FeignClient(name="ia-user-service",value="ia-user-service",url="localhost:9090")
public interface UserService {
	
	@GetMapping("/user/getUserByName")
	List<User> getUserByName(@RequestParam("name") String name);
}
