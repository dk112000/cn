package gobackn;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class client{
    public static void main(String[] args)throws Exception {
        Socket s = new Socket("localhost",3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout =new DataOutputStream(s.getOutputStream());

        int size = din.read();
        int []arr= new int[size];
        
        for(int i=0;i<arr.length;i++){
            arr[i]=din.read();
            if(arr[i]==50){
                arr[i]=-1;
            }
            System.out.println("recieved: "+ arr[i]);
        }
        
        dout.write(4);
        int lframe=0;

        for(int i=4;i<arr.length;i++){
         lframe=din.read();
         System.out.println("frame recieved again: "+lframe);
        }
        System.out.println("last frame recieved: "+lframe);

    }
}
package gobackn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class server{
    public static void main(String args[])throws IOException{
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        int []arr = {10,20,30,40,50,60,70};
        int size = arr.length;
        dout.write(size);

        for(int i=0;i<arr.length;i++){
             System.out.println("sending frame "+arr[i]);
             dout.write(arr[i]);
        }
        
        int eframe = din.read();
        for(int i=eframe;i<arr.length;i++){
        System.out.println("Ressending frame: "+i);
        dout.write(arr[i]);
        }
        ss.close();
    }
}
