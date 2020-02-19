
public abstract class Command {
	public Command() {
		
	}
	
	public abstract boolean matches(String keyword);
	
	public abstract void perform(Connection connection, Users user_database);
}
