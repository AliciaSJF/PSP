import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteTabla {
    static final String HOST = "localhost";
    static final int PUERTO = 5000;

    public class HiloDeServidor implements Runnable
    {
        /* Guardamos el socket del servidor */
    	BufferedReader flujoEntrada;

        /* Constructor al que pasamos el socket del servidor */
        public HiloDeServidor(BufferedReader flujo)
        {
            flujoEntrada = flujo;
        }

        /* Procesa los mensajes del servidor de forma asíncrona */
        public void run() {
            try {
                while (true) {
                    /* Obtenemos el mensaje y lo mostramos */
                    System.out.println(flujoEntrada.readLine());
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String args[]) {
        new ClienteTabla();
    }

    public ClienteTabla() {
        Socket cliente = null;
		String line;
        try {
            cliente = new Socket(HOST, PUERTO);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintStream salida = new PrintStream(cliente.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
            //leemos el mensaje conectado del servidor
			System.out.println(entrada.readLine());
            // A partir de aquí delegamos la lectura de mensajes a un segundo plano
            (new Thread(new HiloDeServidor(entrada))).start();
            System.out.println("¿Que tabla de multiplicar quieres calcular (-1 fin)?");
			line = in.readLine();
			while (!line.equals("-1") && line != null) {
                salida.println(line);
				System.out.println("¿Que tabla de multiplicar quieres calcular (-1 fin)?");
				line = in.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Limite de Peticiones en el Servidor");
        }
        try {
            if (cliente != null) {
                cliente.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Limite de Peticiones en el Servidor");
        }
    }
}

