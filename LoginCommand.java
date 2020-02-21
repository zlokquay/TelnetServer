import java.io.PrintStream;
import java.util.Scanner;

public class LoginCommand extends Command {
	public LoginCommand() {
		
	}
	
	public boolean matches(String keyword) {
		return keyword.equals("AUTH");
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
		
		if(user_database.users.containsKey(credentials[1])) {
			User user = user_database.getUser(credentials[1]);
			if(user.connected()) {
				if (connection.getUser() == user) {
					response.print("202 Already connected as " + credentials[1] + ".\n\r");
				}else {
					response.print("201 User "+credentials[1]+" already connected.\n\r");
				}
			}else {
				if (user.authenticate(credentials[2])){
					user.connect(connection);
					connection.setUser(user);
					response.print("102 Connected as "+ credentials[1] +".\n\r");
				} else {
					response.print("204 Invalid user name or password.\n\r");
				}
			}
			
		}else {
			response.print("200 User "+credentials[0]+" doesn't exists.");
		}
	}
}
