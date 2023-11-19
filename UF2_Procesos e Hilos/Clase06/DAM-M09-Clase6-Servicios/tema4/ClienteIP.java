package tema4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ClienteIP {
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			String token = "id";
			InetAddress addr1 = InetAddress.getByName("localhost");
			DatagramPacket datagrama1 = new DatagramPacket(token.getBytes(),
					token.getBytes().length, addr1, 5556);
			datagramSocket.send(datagrama1);
			byte[] buffer = new byte[128];
			DatagramPacket datagrama2 = new DatagramPacket(buffer, buffer.length);
			datagramSocket.receive(datagrama2);
			String respuesta = new String(buffer);
			System.out.println("Mi dirección es "+respuesta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
