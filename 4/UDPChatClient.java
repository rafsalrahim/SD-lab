import java.io.*;
import java.net.*;
class UDPChatClient
{
public static DatagramSocket clientsocket;
public static DatagramPacket dp;
public static BufferedReader dis;
public static InetAddress ia;
public static byte buf[] = new byte[1024];
public static int cport = 4532, sport = 1025;
public static void main(String[] a) throws IOException
{
clientsocket = new DatagramSocket(cport);
dp = new DatagramPacket(buf, buf.length);
dis = new BufferedReader(new InputStreamReader(System.in));
ia = InetAddress.getLocalHost();
System.out.println("Client is Running... Type 'STOP'to Quit");
while(true)
{
System.out.print("Client: ");
String str = new String(dis.readLine());
if(str.equals("STOP"))
{
System.out.println("Terminated...");
clientsocket.send(new DatagramPacket(buf,str.length(), ia,sport));
break;
}
buf = str.getBytes();
clientsocket.send(new DatagramPacket(buf,str.length(), ia, sport));
clientsocket.receive(dp);
String str2 = new String(dp.getData(), 0, dp.getLength());
System.out.println("Server: " + str2);
}
}
}
