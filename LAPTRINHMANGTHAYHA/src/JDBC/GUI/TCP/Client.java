package JDBC.GUI.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private static int port = 3004;
	static String data ="";
	private static boolean flag = false;
	private static Socket socket ;
	private static DataInputStream dataInputStream ; 
	private static DataOutputStream dataOutputStream;
	public Client() throws UnknownHostException, IOException {
		socket = new Socket("localhost", Client.port);
		flag = true;
		
	}
	public static void Handle() throws IOException {
		Client.dataInputStream = new DataInputStream(socket.getInputStream());
		Client.dataOutputStream = new DataOutputStream(socket.getOutputStream());
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						dataOutputStream.writeUTF("start");
						dataOutputStream.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		thread1.start();
		
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						data = dataInputStream.readUTF();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		thread2.start();
		
	}
	

}
