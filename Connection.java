import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Connection {
	private static List<Command> commands;
	private Scanner input;
	private PrintStream output;
	private Socket socket;
	private User user;
	private Users user_database;
	
	public Connection(Socket socket, Users user_database) {
		
	}
	
	public void close() {
		
	}
	
	public User getUser() {
		return user;
		
	}
	
	public Scanner input() {
		return input;
	}
	
	public PrintStream output() {
		return output;
	}
	
	void run() {
		
	}
	
	public void send(Message message) {
		
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
