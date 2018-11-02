package Bai3.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerRom {
	private static int port = 3002;
	private static ServerSocket serverSocket;
	private static ArrayList<User > ArrUser = new ArrayList<User>();
	
	public ChatServerRom(int port ) throws IOException {
		serverSocket = new ServerSocket(port);
	}
	
	private void ConnectClient() throws IOException {
		while(true) {
			Socket socket = serverSocket.accept();
			User user = new User(socket);
			addUsers(user);
			user.start();
		}
	}
	private void addUsers(User user) {
		synchronized (this) {
			ArrUser.add(user);
		}
		
	}


	private void HandleSend(User user, String str) throws IOException {
		synchronized (this) {
			String tinnhan = user.username+" : "+str;
			for(int i = 0; i < ArrUser.size(); i++) {
				User user2 = ArrUser.get(i);
				if(!user2.username.equals(user.username)) {
					user2.sendSms(tinnhan);
				}
			}
		}
		
	}
	
	private class User extends Thread{
		private Socket socket=  null ;
		private DataInputStream dataInputStream ; 
		private DataOutputStream dataOutputStream ;
		private String username = null;
		
		public User(Socket socket) throws IOException {
			this.socket = socket;	
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
		}
				
		public void sendSms(String tinnhan) throws IOException {
			dataOutputStream.writeUTF(tinnhan);
			dataOutputStream.flush();
		}

		@Override
		public void run() {
			while(true) {
				try {
					String sms = dataInputStream.readUTF();
					if(username == null) {
						username = sms;
					}else {
						HandleSend(this, sms);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}	
	}
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("Start Server !!!");
		ChatServerRom chatServerRom = new ChatServerRom(ChatServerRom.port);
		chatServerRom.ConnectClient();
	}

}
