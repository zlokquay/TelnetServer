import java.util.HashMap;
import java.util.Map;

public class Users {
	
	public Map<String, User> users;
	
	public Users() {
		users = new HashMap<String, User>();
	}
	
	User getUser(String user_name) {
		return users.get(user_name);
	}
	
	boolean isEmpty() {
		return users.isEmpty();
	}
	
	void newUser(String user_name, String password, boolean super_user) {
		users.put(user_name, new User(user_name, password, super_user));
	}
	
}
