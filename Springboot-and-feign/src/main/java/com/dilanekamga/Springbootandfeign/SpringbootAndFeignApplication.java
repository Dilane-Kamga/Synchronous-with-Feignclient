package com.dilanekamga.Springbootandfeign;

import java.util.List;
import com.dilanekamga.Springbootandfeign.client.UserClient;
import com.dilanekamga.Springbootandfeign.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SpringbootAndFeignApplication {

	@Autowired
	private UserClient client;

	@GetMapping("/findAllUser")
	public List<UserResponse> getAllUser() {
		return client.getUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAndFeignApplication.class, args);
	}
}