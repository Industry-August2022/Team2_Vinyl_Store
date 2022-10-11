package team2.vinyl_store.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.User;
import team2.vinyl_store.services.UserService;

@RestController
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(path = "/api/user/{id}")
	public User getById(@PathVariable int id) {
		return userService.getUserByID(id);
	}

	@GetMapping(path = "/api/user")
	public List<User> getAll() {
		return userService.getAllUsers();
	}

	@PostMapping(path = "/api/user")
	public User postNew(@RequestBody User newUser) {
		return userService.insertUser(newUser);
	}

}
