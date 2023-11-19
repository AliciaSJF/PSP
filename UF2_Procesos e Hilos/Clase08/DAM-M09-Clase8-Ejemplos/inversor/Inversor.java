import java.io.IOException;
import java.net.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Inversor {
	public static void main(String[] args) {
		try {
			InetSocketAddress addr = new InetSocketAddress("localhost", 5556);
			DatagramSocket datagramSocket = new DatagramSocket(addr);
			System.out.println("Esperando palabras ....");
			while (true) {
				byte[] buffer = new byte[20];
				DatagramPacket datagrama1 = new DatagramPacket(buffer, buffer.length);
				datagramSocket.receive(datagrama1);
				String cadena = new String(buffer);
				System.out.println(cadena);
				StringBuilder builder=new StringBuilder(cadena);
				String respuesta=builder.reverse().toString();
				DatagramPacket datagrama2 = new DatagramPacket(respuesta.getBytes(),
					respuesta.getBytes().length, datagrama1.getAddress(), datagrama1.getPort());
				datagramSocket.send(datagrama2);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



