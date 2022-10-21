package com.dilanekamga.Springbootandfeign;

import java.util.List;

//import com.dilanekamga.Springbootandfeign.client.UserClient;
import com.dilanekamga.Springbootandfeign.client.UserClient;
import com.dilanekamga.Springbootandfeign.dto.UserResponse;
import com.dilanekamga.Springbootandfeign.entities.AppRole;
import com.dilanekamga.Springbootandfeign.entities.AppUser;
import com.dilanekamga.Springbootandfeign.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SpringbootAndFeignApplication {
	@Autowired
	private UserClient client;
	@Autowired
	private AccountService accountService;

	@GetMapping("/findAllUser")
	public List<UserResponse> getAllUser() {
		return client.getUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAndFeignApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}

	public void run(String... args) throws Exception {
		accountService.saveUser(new AppUser(null, "admin", "1234", null));
		accountService.saveUser(new AppUser(null, "user", "1234", null));
		accountService.saveRole(new AppRole(null, "ADMIN",null));
		accountService.saveRole(new AppRole(null, "USER",null));
		accountService.addRoleToUser("admin", "ADMIN");
		/* accountService.addRoleToUser("admin", "USER");*/
		accountService.addRoleToUser("user", "USER");
	}
}