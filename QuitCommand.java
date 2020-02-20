
public class QuitCommand extends Command {
	public QuitCommand() {
		
	}
	
	public boolean matches(String keyword) {
		return keyword.equals("QUIT");
	}
	
	public void perform(Connection connection, Users user_database) {
		
	}
}
