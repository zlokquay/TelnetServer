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
		String[] credentials = data.nextLine().split(" ");
		if(user_database.users.containsKey(credentials[0])) {
			User user = user_database.getUser(credentials[0]);
			if(user.connected()) {
				if (connection.getUser() == user) {
					response.print("202 Already connected as " + credentials[0]);
				}else {
					response.print("201 User "+credentials[0]+" already connected.");
				}
			}else {
				if (user.authenticate(credentials[1])){
					user.connect(connection);
					response.print("102 Connected as "+credentials[0]+".");
				} else {
					response.print("999 Additional parameters required.");
				}
			}
			
		}else {
			response.print("200 User "+credentials[0]+" doesn't exists.");
		}
	}
}
