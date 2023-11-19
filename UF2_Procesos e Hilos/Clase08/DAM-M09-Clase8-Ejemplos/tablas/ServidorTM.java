
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTM {
	
	public static void main(String args[]) {
	
		// donde almacenaremos el mensaje recibido
		String linea_recibida;
		// variables numericas para los calculos de las operaciones
		float resultado = 0;
		float numero = 0;
		
		int i=0;
	
		//iniciamos el servidor en el puerto 5557 y en localhost
		try {
			// Socket que iniciará nuestro servidor
			ServerSocket conexion = new ServerSocket(5557);
			// esperamos una conexion del cliente
			System.out.println("Esperando conexiones ...");
			Socket socket_conectado = conexion.accept();
			//conectamos la entrada y la salida con el cliente
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_conectado.getInputStream()));
			PrintStream salida = new PrintStream(socket_conectado.getOutputStream());
	
			linea_recibida = entrada.readLine();
			numero= Float.valueOf(linea_recibida);
			while (numero!=-1) {
				//recibimos una linea string
				System.out.println("Tabla de Multiplicar del "+linea_recibida);
				//segun el operando recibido realizamos dicha operacion
				for (i=1;i<10;i++){
					System.out.println(numero+"x"+i+"="+numero*i);
				}
				salida.println("Tabla del "+numero+ " calculada");
				linea_recibida = entrada.readLine();
				numero= Float.valueOf(linea_recibida);
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