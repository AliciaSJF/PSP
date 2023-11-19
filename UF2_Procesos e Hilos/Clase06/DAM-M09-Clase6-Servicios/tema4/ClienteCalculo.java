package tema4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteCalculo {

	public static void main(String[] args) {
	
	// nos conectamos al localhost a traves de esta dirección IP (localhost)
	String ipServidor = "127.0.0.1";
	
	try {
		// conectamos con el servidor con la ip y el puerto definidos
		Socket cliente = new Socket(ipServidor, 5557);
		//conexion para recepcion de datos
		BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		//conexion para envio de datos
		PrintStream salida = new PrintStream(cliente.getOutputStream(), true);
		
		//linea que vamos a recibir del servidor con el resultado
		String linea_recibida, line;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
		System.out.println("Conectado !");
		line = in.readLine();
		while (!line.equals("final") && line != null) {
			// ponemos las lineas en el printStream que las envia al server a través del socket
			salida.println(line);
			salida.flush();
			linea_recibida = entrada.readLine();
			System.out.println("MENSAJE DEL SERVIDOR: " + linea_recibida);
		    line = in.readLine();
		}
		salida.println(line);
		/*
		* ORDENES:
		* suma num1 num2 --> ej: suma 2 5
		* resta num1 num2
		* multiplica num1 num2
		* divide num1 num2
		* sqrt num --> Raiz cuadrada, ej: sqrt 25
		* final --> apagar el servidor remotamente
		*
		* */
		
		entrada.close();
		cliente.close();
	
	} catch (UnknownHostException excepcion) {
	System.err.println("No se puede encontrar el servidor, en la dirección" + ipServidor);
	} catch (IOException excepcion) {
	System.err.println("Error de entrada/salida");
	} catch (Exception e) {
	System.err.println("Error: " + e);
	
	}
	
	}

}
