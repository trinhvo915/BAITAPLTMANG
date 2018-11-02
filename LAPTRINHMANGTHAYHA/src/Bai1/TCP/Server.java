package Bai1.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private static int port = 3000;
	private static ServerSocket serverSocket ;
	public Server() throws IOException {
		this.serverSocket = new ServerSocket(Server.port);
	}
	

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		System.out.println("Start Server !!!");
		Socket socket = server.serverSocket.accept();	
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		while(true) {
			
			String msg = dataInputStream.readUTF();
			String sotu =String.valueOf(DemSoTu(msg)) ;
			String chuoiHoa = sotu +"-"+DoichuoiHoa(msg)+"-"+DoichuoiThuong(msg);
			
			// ****************************//
			dataOutputStream.writeUTF(chuoiHoa);
		}
	}

	private static String DoichuoiHoa(String msg) {
		char [] chuoi = msg.toCharArray();
		String s = "";
		for(int i = 0; i < chuoi.length ; i++) {
			if( chuoi[i] != ' ' &&chuoi[i] >='a' && chuoi[i] <= 'z') {
				chuoi[i] -= (char)32;
				System.out.println(chuoi[i]);
			}
		}
		for(int i = 0; i < chuoi.length ; i++) {
			s += chuoi[i];
		}
		s = s.trim();
		String[] arrMsg = s.split(" ");
		ArrayList<String> arrayList = new ArrayList<String>();
		for(String item : arrMsg) {
			if(!item.equals("")) {
				arrayList.add(item);
			}
		}
		String result ="";
		for(String str : arrayList) {
			result += str + " ";
		}
		return result.trim();
	}

	private static String DoichuoiThuong(String msg) {
		char [] chuoi = msg.toCharArray();
		String s = "";
		for(int i = 0; i < chuoi.length ; i++) {
			if(chuoi[i] != ' ' && chuoi[i] >='A' && chuoi[i] <= 'Z') {
				chuoi[i] += 32;
			}
		}
		for(int i = 0; i < chuoi.length ; i++) {
			s += chuoi[i];
		}
		s = s.trim();
		String[] arrMsg = s.split(" ");
		ArrayList<String> arrayList = new ArrayList<String>();
		for(String item : arrMsg) {
			if(!item.equals("")) {
				arrayList.add(item);
			}
		}
		String result ="";
		for(String str : arrayList) {
			result += str + " ";
		}
		return result.trim();
	}

	
	private static int DemSoTu(String msg) {
		msg = msg.trim();
		String[] arrMsg = msg.split(" ");
		int dem = 0;
		for(String item : arrMsg) {
			if(!item.equals("")) {
				dem++;
			}
		}
		return dem;
	}

	

	

}

