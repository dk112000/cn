package CnAssign;

import java.util.*;
import java.io.*;
import java.net.*;

public class peertopeerServer {
public static void main(String[] args) throws IOException{
	Scanner sc = new Scanner(System.in);
	ServerSocket ss=new ServerSocket(3002);
	Socket s= ss.accept();
	
	DataInputStream din = new DataInputStream(s.getInputStream());
	DataOutputStream dout = new DataOutputStream(s.getOutputStream());
	
	String messageToSend=" ",messageToReceive=" ";
	while(!messageToReceive.equals("stop")) {
		messageToReceive = din.readUTF();
		System.out.println("Client : "+ messageToReceive );
		messageToSend = sc.nextLine();
		dout.writeUTF(messageToSend);
		System.out.println("Message Send Successfully");
	}
	
	 s.close();
	 din.close();
	 dout.close();
	 sc.close();
}
}
