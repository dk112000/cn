package CnAssign;

import java.io.*;
import java.net.*;
import java.util.*;

public class peertopeerClient {
	
public static void main (String[] args)throws Exception {
	Scanner sc= new Scanner(System.in);
 Socket s = new Socket("localhost",3002);
 DataInputStream din=new DataInputStream(s.getInputStream());
 DataOutputStream dout=new DataOutputStream(s.getOutputStream());
 
 String messageToSend=" ",messageToReceive=" ";
 while(!messageToReceive.equals("stop")) {
	messageToSend=sc.nextLine();
	dout.writeUTF(messageToSend);
	System.out.println("Message Send Successfully");
	dout.flush();
	messageToReceive=din.readUTF();
	System.out.println("Server : "+ messageToReceive);
 }
 
 s.close();
 din.close();
 dout.close();
 sc.close();
}

}
