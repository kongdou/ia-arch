package ia.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RestController
@SpringBootApplication
public class GateWayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateWayServiceApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> testFunRouterFunction() {
		RouterFunction<ServerResponse> route = RouterFunctions.route(RequestPredicates.path("/test"),
				request -> ServerResponse.ok().body(BodyInserters.fromObject("I am testing")));
		return route;

	}
	
	@RequestMapping("/fallback")
    public String fallback(){
        return "操作超时";
    }
	
	

}
