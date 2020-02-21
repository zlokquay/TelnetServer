import java.io.PrintStream;
import java.util.Scanner;

public class SendCommand extends Command {
	public SendCommand() {
		
	}
	
	public boolean matches(String keyword) {
		return keyword.equals("SEND");
	}
	
	public void perform(Connection connection, Users user_database) {
		Scanner data = connection.input();
		PrintStream response = connection.output();
		String to_user = null;
		String text = null;
		
		if(connection.isConnected()) {
			response.print("206 Not connected as a user.\n\r");
			data.nextLine();
			return;
		}
		
		if(data.hasNext()) {
			to_user = data.useDelimiter(" ").next();
		} else {
			response.print("999 Additional parameters required.\n\r");
		}
		
		if(data.hasNext()) {
			text = data.nextLine();
		} else {
			response.print("998 No message body given.\n\r");
		}
		
		if (user_database.users.containsKey(to_user)) {
			user_database.users.get(to_user).send(new Message(connection.getUser(), text));
			response.print("101 Message sent.\n\r");
		} else {
			response.print("200 User " + to_user +" doesn't exist.\n\r");
		}
	}
}
