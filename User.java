import java.util.List;

public class User {
	private Connection connection;
	private List<Message> messages;
	private String password;
	private boolean super_user;
	private String user_name;
	
	public User(String user_name, String password, boolean super_user) {
		this.user_name = user_name;
		this.password = password;
		this.super_user = super_user;
	}
	
	public boolean authenticate(String password) {
		return false;
	}
	
	public void clearMessages() {
		messages.clear();
	}
	
	public void connect(Connection connection) {
		
	}
	
	public boolean connected() {
		return false;
	}
	
	public void disconnect() {
		
	}
	
	public int hashCode() {
		return user_name.hashCode();
	}
	
	public List<Message> messages(){
		return messages;
	}
	
	public void send(Message message) {
		messages.add(message);
	}
	
	public String username() {
		return user_name;
	}
}
