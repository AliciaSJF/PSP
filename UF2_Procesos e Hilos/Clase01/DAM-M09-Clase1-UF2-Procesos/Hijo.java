import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo{

    public static void main(String[] args) {
       // String lineaRecep;
        String lineaEnvio;
        

        try {
            // BufferedReader por donde recibe los datos que 
            // envia el proceso padre.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            lineaEnvio = new String();
           
            lineaEnvio=br.readLine() + " recibida y procesada";
            System.out.println(lineaEnvio);
           
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}