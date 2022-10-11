package team2.vinyl_store.auth;

public class LoginResponse {

	private String message;
	private boolean success;

	public LoginResponse() {
		super();
	}

	public LoginResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
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
		return "LoginResponse [message=" + message + ", success=" + success + "]";
	}

}