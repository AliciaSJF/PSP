import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Padre {

    public static void main(String args[]) {
        String line;

        try {
            // Ejecución proceso hijo (previamente empaquetado en un JAR)
            Process hijo = new ProcessBuilder("java", "-jar", "c:\\tempjava\\Hijo.jar").start();
            // buffer de recepción de datos del proceso hijo
            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
            // Stream de salida
            PrintStream ps = new PrintStream(hijo.getOutputStream(), true);
            // buffer de lectura de consola
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Ejemplo de comunicacion entre proceso padre e hijo");
            System.out.println("Envía un mensaje al proceso hijo:");
            /* Envio */
            line = in.readLine();
            ps.println(line);
            /* Recepcion */
            line = br.readLine();
            System.out.println(line);
           

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
