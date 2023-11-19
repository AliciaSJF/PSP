import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.*;
public class EnviarPalabra {

    public static void main(String [] args){
        try {
			DatagramSocket datagramSocket = new DatagramSocket();
			String frase = "";
			DatagramPacket datagrama1, datagrama2;
			InetAddress addr1 = InetAddress.getByName("localhost");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
			System.out.println("Conectado !");
			while (!frase.equals("fin") && frase != null) {
				System.out.println("¿Que palabra quieres invertir (fin->final)?");
				frase = in.readLine();
				datagrama1 = new DatagramPacket(frase.getBytes(),frase.getBytes().length, addr1, 5556);
				datagramSocket.send(datagrama1);
				byte[] buffer = new byte[128];
				datagrama2 = new DatagramPacket(buffer, buffer.length);
				datagramSocket.receive(datagrama2);
				String respuesta = new String(buffer);
				System.out.println("Palabra invertida:"+respuesta);
				}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}