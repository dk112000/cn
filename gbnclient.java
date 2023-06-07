import java.util.*;
import java.net.*;
import java.io.*;

public class gbnclient{
public static void main(String[] args) throws Exception{

Scanner sc = new Scanner(System.in);

Socket s = new Socket("localhost", 3006);

DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());

int len = din.read();

int a[] = new int[len];
 
for(int i=0; i<len; i++){
a[i]=din.read();
}

int n=10;
a[7]=-1;

for(int k=0; k<len; k++){
    System.out.println("Data recieved : "+a[k]);
    if(a[k]==-1){
        n=k;
        dout.write(k);
    }
}
System.out.println("\n");

for(int j=n; j<len; j++){
    a[j]=din.read();
    System.out.println("Data recieved : "+a[j]);
}

s.close();
dout.close();
din.close();

}
}