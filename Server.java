import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

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
		
		
		//we have null pointer errors here when trying to connect in putty. unsure why.
		while(true) {
			try {
				Socket sock = server_socket.accept();
				Connection conn = new Connection(sock, user_database);
				Thread t;
				t = new Thread(conn);
				t.start();
			} catch (IOException caught) {
				caught.printStackTrace();
			}
		}
	}
}
