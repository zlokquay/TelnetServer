import java.io.PrintStream;
import java.util.Scanner;


public class CreateCommand extends Command {
	public CreateCommand() {
		
	}
	
	public boolean matches(String keyword) {
		return keyword.equals("CRTE");
	}
	
	public void perform(Connection connection, Users user_database) {
		Scanner data = connection.input();
		PrintStream response = connection.output();
		String[] credentials = null;
		if (data.hasNext()) {
			credentials = data.nextLine().split(" ");
		} else {
			response.print("999 Additional parameters required.\n\r");
		}
		
		if (user_database.isEmpty()) {
			user_database.newUser(credentials[1], credentials[2], true);
			response.print("105 User "+credentials[1]+" created as superuser.\n\r");
			
		} else if(user_database.users.containsKey(credentials[1])) {
			response.print("203 User "+credentials[1]+" already exists.\n\r");
			
		} else {
			user_database.newUser(credentials[1], credentials[2], false);
			response.print("104 User "+credentials[1]+" created.\n\r");
		}
	}
}
