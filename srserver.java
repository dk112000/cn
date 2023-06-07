import java.util.*;
import java.net.*;
import java.io.*;

public class srserver{
public static void main(String[] args) throws Exception{

Scanner sc = new Scanner(System.in);

ServerSocket ss = new ServerSocket(3006);
Socket s = ss.accept();

DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());

int a[]={10,20,30,40,50,60,70,80,90,100};
int len = a.length;
dout.write(len);

for(int i=0; i<len; i++){
dout.write(a[i]);
}

int n=din.read();
dout.write(a[n]);
    

    ss.close();
    s.close();
    dout.close();
    din.close();
}
}