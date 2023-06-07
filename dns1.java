import java.net.*;
import java.util.*;

public class dns{

public static void main(String[] args) throws Exception{

Scanner sc = new Scanner(System.in);
System.out.println("Enter ip :");
String ip= sc.next();

InetAddress address = InetAddress.getByName(ip);www

System.out.println("Enter ip :" + address.getHostAddress()+" Name :"+address.getHostName());
}

}