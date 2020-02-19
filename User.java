import java.util.List;

public class User {
	private Connection connection;
	private List<Message> messages;
	private String password;
	private boolean super_user;
	private String user_name;
	
	public User(String user_name, String password, boolean super_user) {
		
	}
	
	public boolean authenticate(String password) {
		return false;
	}
	
	public void clearMessages() {
		
	}
	
	public void connect(Connection connection) {
		
	}
	
	public boolean connected() {
		return false;
	}
	
	public void disconnect() {
		
	}
	
	public int hashCode() {
		return 0;
	}
	
	public List<Message> messages(){
		return messages;
	}
	
	public void send(Message message) {
		
	}
	
	public String username() {
		return user_name;
	}
}
