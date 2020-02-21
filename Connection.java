import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connection implements Runnable{
	private static List<Command> commands = new ArrayList<Command>();
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
			this.output = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commands.add(new CreateCommand());
		commands.add(new LoginCommand());
		commands.add(new QuitCommand());
		commands.add(new SendCommand());
		
		output.print("Welcome. Please enter a command. \n\r");
	}
	
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isConnected() {
		return !socket.isClosed();
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
		
		while(!socket.isClosed()) {
			String cur_command = null;
			if(input.hasNext()) {
				 cur_command = input.next();
			}
			
			for(int i = 0; i < commands.size(); i++) {
				Command check = commands.get(i);
				if (check.matches(cur_command)){
					check.perform(this, user_database);
					break;
				} else if (i == (commands.size()-1)) {
					output.print("No such command \"" + cur_command + "\".\n\r");
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
