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
		String[] credentials = data.nextLine().split(" ");
		if(user_database.users.containsKey(credentials[0])) {
			response.print("203 User "+credentials[0]+" already exists.");
		}
		else if (credentials[1] == null || credentials[2] == null) {
			response.print("999 Additional paramters required.");
		} else {
			if (user_database.isEmpty()) {
				user_database.newUser(credentials[0], credentials[1], true);
				response.print("105 User "+credentials[0]+" created as superuser.");
			}else {
				user_database.newUser(credentials[0], credentials[1], false);
				response.print("104 User "+credentials[0]+" created.");
			}
		}
	}
}
