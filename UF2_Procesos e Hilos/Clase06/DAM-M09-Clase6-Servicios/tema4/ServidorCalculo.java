package tema4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculo {
	
	public static void main(String args[]) {
	
		// donde almacenaremos el mensaje recibido
		String linea_recibida;
		// variables numericas para los calculos de las operaciones
		float resultado = 0;
		float numero1 = 0;
		float numero2 = 0;
	
		//iniciamos el servidor en el puerto 5557 y en localhost
		try {
			// Socket que iniciará nuestro servidor
			ServerSocket conexion = new ServerSocket(5557);
			// esperamos una conexion del cliente
			Socket socket_conectado = conexion.accept();
			//conectamos la entrada y la salida con el cliente
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_conectado.getInputStream()));
			PrintStream salida = new PrintStream(socket_conectado.getOutputStream());
	
			boolean salir = false;
			while (!salir) {
				//recibimos una linea string
				linea_recibida = entrada.readLine();
				//realizamos la separacion de las partes(operando y numeros a operar)
				String linea[] = linea_recibida.split(" ");
				//string para almacenar la operacionan pedida para concadenarla en el mensaje
				String operacion = "";
	
				//en caso de tres datos recibidos
				if (linea.length == 3) {
				
				//extraemos los numeros para operar
				numero1 = Float.valueOf(linea[1]);
				numero2 = Float.valueOf(linea[2]);
				
				//segun el operando recibido realizamos dicha operacion
				switch (linea[0]) {
					case "suma":
					operacion = "Suma";
					resultado = numero1 + numero2;
					break;
					case "multiplica":
					operacion = "Multiplicacion";
					resultado = numero1 * numero2;
					break;
					case "divide":
					operacion = "Division";
					resultado = numero1 / numero2;
					break;
					case "resta":
					operacion = "Resta";
					resultado = numero1 - numero2;
					break;
				}
				// en caso de solo dos datos(raiz cuadrada)
				} else if (linea.length == 2) {
				switch (linea[0]) {
					case "sqrt":
					numero1 = Float.valueOf(linea[1]);
					operacion = "Raiz";
					resultado = (float) Math.sqrt(numero1);
					break;
				}
	
				//en caso de un dato (apagar el servidor)
				} else if (linea.length == 1) {
				
				switch (linea[0]) {
					case "final":
					salir = true;
					break;
				}
				}
				// mensaje que enviamos al cliente con el resultado
				if (salir) {
				salida.println("Apagando el servidor...");
				} else if (operacion=="Raiz") {
					salida.println("La "+operacion+" de "+numero1+" da como resultado: " + resultado);
				}
				else {
				salida.println("La "+operacion+" de "+numero1+
				" y "+numero2+" da como resultado: " + resultado);
				}
	
			}
		//cerramos los buffer de conexion con el cliente
		salida.close();
		entrada.close();
		// cerramos el socket para cerrar el servidor
		socket_conectado.close();
		} catch (IOException excepcion) {
		System.out.println(excepcion);
		}
	}
}