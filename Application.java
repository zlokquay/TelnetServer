/*
 * ST. MARY'S ILLUSTRIOUS
 * 
 *         ZACHARY TAYLOR!
 *                  & 
 *                MATT MANOLY!
 * 
 *      in............
 * 
 *   TELNET SERVER COSC SOMETHING PROJECT 1!!!!
 * 
 */


public class Application {
	public static void main(String args[]) {
		
		int server_port = 7778;
		Thread server;
		
		//how are we accepting new connections?
		
		
		server = new Thread(new Server(server_port));
		server.start();
	}
}
