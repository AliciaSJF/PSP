import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
/**
 *
 * @author santifergon
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String linea;
       System.out.println("Si tecleas FIN el programa acaba");
       try{
    	   while (true) {
	            Process conversor = new ProcessBuilder("java","-jar","Conversor.jar").start();
	            BufferedReader br = new BufferedReader(new InputStreamReader(conversor.getInputStream()));
	            PrintStream ps = new PrintStream(conversor.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	            System.out.print("Dato para el calculo: ");
	            linea = in.readLine();
	            if (linea.equals("FIN")){
	            	System.out.println("SE ACABO");
	            	break;
	            }
	            ps.println(linea);
	            linea = br.readLine();
	            System.out.println(linea);
    	   }
       }catch(IOException e){
          System.out.println("ERROR: " + e.getMessage());
       }
    }
    
}