package team2.vinyl_store.auth;

public class RegisterHolder {

	private String address;
	private String username;
	private String password;
	private String paymentInfo;

	public RegisterHolder() {
		super();
	}

	public RegisterHolder(String address, String username, String password, String paymentInfo) {
		super();
		this.address = address;
		this.username = username;
		this.password = password;
		this.paymentInfo = paymentInfo;
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

	@Override
	public String toString() {
		return "RegisterHolder [username=" + username + ", password=" + password + ", address=" + address
				+ ", paymentInfo=" + paymentInfo + "]";
	}

}