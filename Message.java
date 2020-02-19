
public class Message {
	private User from;
	private String message;
	
	public Message(User from, String message) {
		this.from = from;
		this.message = message;
	}
	
	public User from() {
		return from;
	}
	
	public String message() {
		return message;
	}
}
