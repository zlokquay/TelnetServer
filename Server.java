import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Server implements Runnable{
	
	private ServerSocket server_socket;
	private Users user_database;
	
	public Server (int port) {
		try {
			
			server_socket = new ServerSocket(port);
			
			System.out.println(InetAddress.getLocalHost());
			
		} catch (IOException caught) {
			System.out.println(caught);
		}
	}
	
	public void run() {
		System.out.println("Server starting...\r");
		
		while(true) {
			try {
				new Connection(server_socket.accept(), user_database);
			} catch (IOException caught) {
				System.out.println(caught);
			}
		}
	}
}
