
public class LoginCommand extends Command {
	public LoginCommand() {
		
	}
	
	public boolean matches(String keyword) {
		return true;
	}
	
	public void perform(Connection connection, Users user_database) {
		String[] credentials = connection.fuckinggetdatasomehow().split(" ");
		if(user_database.users.containsKey(credentials[0])) {
			User user = user_database.getUser(credentials[0]);
			if(user.connected()) {
				if (connection.getUser() == user) {
					connection.printSomehow("202 Already connected as " + credentials[0]);
				}else {
					connection.printSomehow("201 User "+credentials[0]+" already connected.");
					connection.setUser(user);
				}
			}else {
				if (user.authenticate(credentials[1])){
					user.connect(connection);
					connection.printSomehow("102 Connected as "+credentials[0]+".");
				}		
			}
			
		}else {
			connection.printSomehow("200 User "+credentials[0]+" doesn't exists.");
		}
	}
}
