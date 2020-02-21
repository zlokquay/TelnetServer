
public class CreateCommand extends Command {
	public CreateCommand() {
		
	}
	
	public boolean matches(String keyword) {
		return true;
	}
	
	public void perform(Connection connection, Users user_database) {
		String[] credentials = connection.fuckinggetdatasomehow().split(" ");
		if(user_database.users.containsKey(credentials[0])) {
			connection.printSomehow("203 User "+credentials[0]+" already exists.");
		}else {
			if (user_database.isEmpty()) {
				user_database.newUser(credentials[0], credentials[1], true);
				connection.printSomehow("105 User "+credentials[0]+" created as superuser.");
			}else {
				user_database.newUser(credentials[0], credentials[1], false);
				connection.printSomehow("104 User "+credentials[0]+" created.");
			}
		}
	}
}
