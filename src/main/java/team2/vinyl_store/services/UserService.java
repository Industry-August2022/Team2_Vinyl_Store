package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.User;
import team2.vinyl_store.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	protected UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUserByID(int id) {
		return userRepository.findById(id).get();
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public User insertUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllCategories() {
		return userRepository.findAll();
	}

}
