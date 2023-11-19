import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

class Hilo extends Thread{
	String recibida;
	BufferedReader entrada;
	
	Hilo(BufferedReader entrada){
		
		this.entrada=entrada;
	}
	public void run() {
		try {
			recibida = entrada.readLine();
			System.out.println("El servidor dice:" + recibida);
		}catch(IOException e) {
			
		}
	}
}


public class Cliente {

	public static void main(String[] args) {
		String ipServidor = "localhost";
		String recibida="";
		Scanner sc = new Scanner(System.in);
		String mensaje="";
		
		try {
			Socket conexion = new Socket(ipServidor,5050);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			PrintStream salida = new PrintStream(conexion.getOutputStream());
			while(!mensaje.equals("--SALIR--")) {
				Hilo hilo = new Hilo(entrada);
				hilo.start();
				System.out.print("Mensaje a enviar: ");
				mensaje = sc.nextLine();
				salida.println(mensaje);
				
				
			}
			entrada.close();
			salida.close();
			conexion.close();
		}catch(IOException e) {
			
		}
	}
}