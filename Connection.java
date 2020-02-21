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
		
		try {
			this.input = new Scanner(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commands.set(0, new CreateCommand());
		commands.set(1, new LoginCommand());
		commands.set(2, new QuitCommand());
		commands.set(3, new SendCommand());
	}
	
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			
			String cur_command = input.next(" ");
			
			for(int i = 0; i < commands.size(); i++) {
				Command check = commands.get(i);
				if (check.matches(cur_command)){
					check.perform(this, user_database);
				}
			}
		}
	}
	
	public void send(Message message) {
		user.send(message);
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
