package Bai3.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClientRom extends Thread{
	private static int port = 3002;
	private static Socket socket ;
	private static DataInputStream inClien;
	private static DataOutputStream outClient;
	public ChatClientRom(String host, int port ) throws UnknownHostException, IOException {
		socket = new Socket(host, port);
		inClien = new DataInputStream(socket.getInputStream());
		outClient = new DataOutputStream(socket.getOutputStream());
	}
	private  void send(String sms) throws IOException { 
		outClient.writeUTF(sms);
	}
	// tao luong nhap tu server
	
	@Override
	public void run() {
		while(true) {
			try {
				String smsR = inClien.readUTF();
				System.out.println(smsR);
				System.out.println("You : ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String input() throws IOException {
		String str;
		DataInputStream  dataInputStream = new DataInputStream(System.in);
		str = dataInputStream.readLine();
		return str;
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClientRom chatClientRom = new ChatClientRom("localhost", ChatClientRom.port);
		System.out.println("Moi ban nhap username !!!");
		String username= input();
		chatClientRom.send(username);
		// start de nhan du lieu tu server - multi - client
		chatClientRom.start();
		
		// nhap tin nhan cho client
		while(true) {
			
			String sms = input();
			chatClientRom.send(sms);
		}
		
	}

}
