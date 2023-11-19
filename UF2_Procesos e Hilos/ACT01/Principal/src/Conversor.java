
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author santifergon
 */
public class Conversor {
    
    public static void main (String[] args){
        int lineaEvento;
        String numero;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            lineaEvento = Integer.parseInt(br.readLine());
            numero = Integer.toBinaryString(lineaEvento);
            System.out.println(numero);
            
        }catch(IOException e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}