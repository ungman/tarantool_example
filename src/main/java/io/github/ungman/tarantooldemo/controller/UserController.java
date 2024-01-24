package io.github.ungman.tarantooldemo.controller;

import io.github.ungman.tarantooldemo.entity.User;
import io.github.ungman.tarantooldemo.service.UserService;

import java.util.Set;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;


	@GetMapping("/{login}")
	public User get(@PathVariable String login){
		return userService.get(login);
	}

	@GetMapping
	public Set<User> getAll(){
		return userService.getAll();
	}

	@PostMapping
	public User insert(User user){
		throw new UnsupportedOperationException();
	}

	@DeleteMapping
	public void delete(User user){
		throw new UnsupportedOperationException();
	}
}
