import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Server implements Runnable{
	
	private ServerSocket server_socket;
	private Users user_database;
	
	public Server (int port) {
		try {
			
			server_socket = new ServerSocket(port);
			user_database = new Users();
			
			System.out.println(InetAddress.getLocalHost());
			
		} catch (IOException caught) {
			caught.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("Server starting...\r");
		
		
		//we have null errors here when trying to connect in putty. unsure why.
		while(true) {
			try {
				new Thread(new Connection(server_socket.accept(), user_database)).start();
			} catch (IOException caught) {
				caught.printStackTrace();
			}
		}
	}
}
