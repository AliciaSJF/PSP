import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTabla
{
	public static void main(String args[]) {
		
		// donde almacenaremos el mensaje recibido
		String linea_recibida;
		// variables numericas para los calculos de las operaciones
		int resultado=0;
		int i = 0;
		int numero1 = 0;
        try {
      

			// Socket que iniciará nuestro servidor
			ServerSocket conexion = new ServerSocket(5000);
			// esperamos una conexion del cliente
			System.out.println("Esperando conexiones");
			Socket socket_conectado = conexion.accept();
			//conectamos la entrada y la salida con el cliente
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_conectado.getInputStream()));
			PrintStream salida = new PrintStream(socket_conectado.getOutputStream());
			salida.println("conectado al servidor...");
			linea_recibida = entrada.readLine();
			numero1= Integer.valueOf(linea_recibida);
			while (numero1!=-1) {
				//recibimos una linea string
				System.out.println("Tabla de Multiplicar del "+linea_recibida);
				//el resultado lo mostramos en la salida
				salida.println("Tabla de Multiplicar del "+linea_recibida);
				for (i=1;i<10;i++) {
					resultado=numero1*i;
					salida.println(numero1+" x " + i +" = "+ resultado);
				}
				linea_recibida = entrada.readLine();
				numero1= Integer.valueOf(linea_recibida);
			}
			//cerramos los buffer de conexion con el cliente
			salida.close();
			entrada.close();
			// cerramos el socket para cerrar el servidor
			socket_conectado.close();
			            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


