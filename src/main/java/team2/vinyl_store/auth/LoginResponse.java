package team2.vinyl_store.auth;

public class LoginResponse {

	private String message;
	private boolean success;
	private int userId;

	public LoginResponse(String message, boolean success, int userId) {
		super();
		this.message = message;
		this.success = success;
		this.userId = userId;
	}

	public LoginResponse() {
		super();
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "LoginResponse [message=" + message + ", success=" + success + ", userId=" + userId + "]";
	}

}