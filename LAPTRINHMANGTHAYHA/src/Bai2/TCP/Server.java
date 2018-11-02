package Bai2.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Stack;

public class Server {
	private static int port = 3001;
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

			
			
			String s= String.valueOf(server.result(msg));
			dataOutputStream.writeUTF(s);
		}
	}

	public int priority(char c) {
		if (c == '+' || c == '-')
			return 1;
		else if (c == '*' || c == '/')
			return 2;
		else
			return 0;
	}

	public boolean isOperation(char c) {
		if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')')
			return false;
		else
			return true;
	}

	public String[] processString(String sMath) {
		String s1 = "";
		String elementString[] = null;
		sMath = sMath.trim();
		for (int i = 0; i < sMath.length(); i++) {
			char c = sMath.charAt(i);
			if (!isOperation(c))
				s1 += c;
			else
				s1 += " " + c + " ";
		}
		s1 = s1.trim();
		elementString = s1.split(" ");
		String s = "";
		for (String string : elementString) {
			if (!string.equals("")) {
				s += string + " ";
			}
		}
		return s.split(" ");
	}

	public String[] postfix(String[] elementMath) {
		String s1 = "";
		Stack<String> s = new Stack<>();
		for (int i = 0; i < elementMath.length; i++) {
			char c = elementMath[i].charAt(0);
			if (!isOperation(c)) {
				s1 = s1 + " " + elementMath[i];
			} else {
				if (c == '(') {
					s.push(elementMath[i]);
				} else {
					if (c == ')') {
						char c1;
						do {
							if (s.isEmpty())
								System.out.println("ho");
							c1 = s.peek().charAt(0);
							if (c1 != '(')
								s1 = s1 + ' ' + s.peek();
							s.pop();
						} while (c1 != '(');
					} else {
						while (!s.isEmpty() && priority(s.peek().charAt(0)) >= priority(c)) {
							s1 = s1 + " " + s.peek();
							s.pop();
						}
						s.push(elementMath[i]);
					}
				}
			}
		}
		while (!s.isEmpty()) {
			s1 = s1 + " " + s.peek();
			s.pop();
		}
		return s1.trim().split(" ");
	}

	public double result(String s) {
		String element[] = postfix(processString(s));
		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < element.length; i++) {
			if (!isOperation(element[i].charAt(0))) {
				stack.push(Double.parseDouble(element[i]));
			} else {
				double a = stack.pop();
				double b = stack.pop();
				switch (element[i].charAt(0)) {
				case '+':
					stack.push(a + b);
					break;
				case '-':
					stack.push(b - a);
					break;
				case '*':
					stack.push(b * a);
					break;
				case '/':
					stack.push(b / a);
					break;
				}
			}
		}
		return stack.pop();
	}
}



