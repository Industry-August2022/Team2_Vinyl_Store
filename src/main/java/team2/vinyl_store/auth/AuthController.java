package team2.vinyl_store.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.User;
import team2.vinyl_store.services.UserService;

@RestController
public class AuthController {

	private UserService userService;
	private MessageDigest messageDigest;

	@Autowired
	public AuthController(UserService userService) {
		this.userService = userService;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	@PostMapping(path = "/api/auth/login")
	public LoginResponse login(@RequestBody LoginHolder loginHolder) {
		User user = userService.getUserByUsername(loginHolder.getUsername());
		if (user == null)
			return new LoginResponse("unknown username or password", false);
		
		messageDigest.update(loginHolder.getPassword().getBytes());
		String passHash = new String(messageDigest.digest());

		if (user.getPassword().equals(passHash))
			return new LoginResponse("user authenticated", true);
		return new LoginResponse("unknown username or password", false);
	}

	@PostMapping(path = "/api/auth/register")
	public LoginResponse register(@RequestBody RegisterHolder registerHolder) {
		User user = userService.getUserByUsername(registerHolder.getUsername());
		if (user != null)
			return new LoginResponse("user already registered", false);
		
		messageDigest.update(registerHolder.getPassword().getBytes());
		String passHash = new String(messageDigest.digest());
		
		User newUser = new User(-1, registerHolder.getAddress(), registerHolder.getUsername(),
				passHash, registerHolder.getPaymentInfo(), false);
		userService.insertUser(newUser);
		return new LoginResponse("user registered", true);
	}

}
