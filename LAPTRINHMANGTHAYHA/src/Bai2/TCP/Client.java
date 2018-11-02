package Bai2.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private static int port = 3001;
	private static boolean flag = false;
	private static Socket  socket ;
	public Client() throws UnknownHostException, IOException {
		this.socket = new Socket("localhost", Client.port);
		this.flag = true;
	}
	public static String Input() throws IOException {
		String s = "";
		DataInputStream inputStream = new DataInputStream(System.in);
		s = inputStream.readLine();
		return s;
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Start Client !!!");
		//DataInputStream dataInputStream = null;
		Client client = new Client();
		
		while(true) {
			if(flag == true) {
			
				DataOutputStream dataOutputStream = new DataOutputStream(Client.socket.getOutputStream());
				System.out.println("Moi ban nhap chuoi !!!");
				String chuoi = Client.Input();
				dataOutputStream.writeUTF(chuoi);
				dataOutputStream.flush();
				
				DataInputStream dataInputStream = new DataInputStream(Client.socket.getInputStream());
				String msg = dataInputStream.readUTF();
				System.out.println("Ket Qua :" +msg);
			}
		}
		
	}
}
