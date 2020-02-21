import java.io.PrintStream;
import java.util.ArrayList;
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
		this.messages = new ArrayList<Message>();
	}
	
	public boolean authenticate(String password) {
		return this.password.equals(password);
	}
	
	public void clearMessages() {
		messages.clear();
	}
	
	public void connect(Connection connection) {
		this.connection = connection;
		PrintStream output = connection.output();
		for(int i = 0; i < messages.size(); i++) {
			output.print("100 Message from " + messages.get(i).from().username() + " follows:\"" + messages.get(i).message() + "\"\n\r");
		}
	}
	
	public boolean connected() {
		return connection != null && connection.isConnected();
	}
	
	public void disconnect() {
		connection.close();
	}
	
	public int hashCode() {
		return user_name.hashCode();
	}
	
	public List<Message> messages(){
		return messages;
	}
	
	public void send(Message message) {
		if (connected()) {
			connection.output().print("100 Message from " + message.from().username() + " follows:\"" + message.message() + "\"\n\r");
		} else {
			System.out.println("beep");
			messages.add(message);
		}
	}
	
	public String username() {
		return user_name;
	}
}
