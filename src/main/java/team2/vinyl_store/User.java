package team2.vinyl_store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String address;
	private String username;
	private String password;
	private String paymentInfo;

	private boolean isAdmin;

	public User() {
	}

	public User(int userId, String address, String username, String password, String paymentInfo, boolean isAdmin) {
		this.userId = userId;
		this.address = address;
		this.username = username;
		this.password = password;
		this.paymentInfo = paymentInfo;
		this.isAdmin = isAdmin;
	}

	public int getUserID() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", address=" + address + ", username=" + username + ", password=" + password
				+ ", paymentInfo=" + paymentInfo + ", isAdmin=" + isAdmin + "]";
	}

}
