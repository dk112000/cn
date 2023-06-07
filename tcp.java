package peertopeer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.sound.midi.Sequencer.SyncMode;

public class client {
    public static void main(String[] args) throws Exception{ 
        Socket s = new Socket("localhost",3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        Scanner in = new Scanner(System.in);

        String smsg = "",rmsg="";
        
        while(!rmsg.equals("Bye")){
            System.out.print("client: ");
            smsg = in.nextLine();
            dout.writeUTF(smsg);
            rmsg=din.readUTF();
            System.out.println("Server: "+rmsg);
        }
        in.close();
        s.close();
   
    }
}
package peertopeer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        Scanner in = new Scanner(System.in);
        
        String smsg="",rmsg="";
        
        while(!smsg.equals("Bye")){
            rmsg = din.readUTF();
            System.out.println("client: "+ rmsg);
            System.out.print("server: ");
            smsg = in.nextLine();
            dout.writeUTF(smsg);
        }
       
        s.close();
        in.close();
        ss.close();

    }
    
}
