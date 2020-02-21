
public class SendCommand extends Command {
	public SendCommand() {
		
	}
	
	public boolean matches(String keyword) {
		return keyword.equals("SEND");
	}
	
	public void perform(Connection connection, Users user_database) {
		
	}
}
