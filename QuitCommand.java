import java.io.PrintStream;

public class QuitCommand extends Command {
	public QuitCommand() {
		
	}
	
	public boolean matches(String keyword) {
		return keyword.equals("QUIT");
	}
	
	public void perform(Connection connection, Users user_database) {
		PrintStream response = connection.output();
		User cur_user = connection.getUser();
		
		if(cur_user == null) {
			response.print("206 Not connected as a user.\n\r");
		} else {
			response.print("Bye.\n\r");
			cur_user.disconnect();
		}
	}
}
