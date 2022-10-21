package com.dilanekamga.Springbootandfeign.client;

import java.util.List;

import com.dilanekamga.Springbootandfeign.dto.UserResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url="https://jsonplaceholder.typicode.com",name="USER-CLIENT")
public interface UserClient {

	@GetMapping("/users")
	public List<UserResponse> getUsers();
	
}
