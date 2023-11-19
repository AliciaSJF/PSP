
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;


class HiloServidor extends Thread{
	String recibida;
	BufferedReader entrada;
	
	HiloServidor(BufferedReader entrada){
		
		this.entrada=entrada;
	}
	public void run() {
		try {
			recibida = entrada.readLine();
			System.out.println("El cliente dice: " + recibida);
		}catch(IOException e) {
			
		}
	}
}


public class Servidor {

	public static void main(String[] args) {
		String recibida="";
		Scanner sc = new Scanner(System.in);
		String mensaje="";
		
		try {
			ServerSocket conexion = new ServerSocket(5050);
			Socket conectado = conexion.accept();
			BufferedReader entrada = new BufferedReader(new InputStreamReader(conectado.getInputStream()));
			PrintStream salida = new PrintStream(conectado.getOutputStream());
			while(!mensaje.equals("--SALIR--")) {
				HiloServidor hilo = new HiloServidor(entrada);
				hilo.start();
				System.out.print("Mensaje: ");
				mensaje = sc.nextLine();
				salida.println(mensaje);
			}
			salida.close();
			entrada.close();
			conectado.close();
		}catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
