import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Connection implements Runnable{
	private static List<Command> commands;
	private Scanner input;
	private PrintStream output;
	private Socket socket;
	private User user;
	private Users user_database;
	
	public Connection(Socket socket, Users user_database) {
		this.socket = socket;
		this.user_database = user_database;
		//this.input = socket.getInputStream();
		commands.set(0, new CreateCommand());
		commands.set(1, new LoginCommand());
		commands.set(2, new QuitCommand());
		commands.set(3, new SendCommand());
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
	
	public void run() {
		
		input = this.input();
		
		while(true) {
			
			String line = input.nextLine();
			String cur_command = line.substring(0, 3);
			String data = line.substring(3);
			
			for(int i = 0; i < commands.size(); i++) {
				Command check = commands.get(i);
				if (check.matches(cur_command)){
					check.perform(this, user_database);
				}
			}
		}
	}
	
	public void send(Message message) {
		
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
