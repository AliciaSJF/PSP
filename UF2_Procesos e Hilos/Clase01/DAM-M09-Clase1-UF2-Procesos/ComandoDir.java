import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ComandoDir {
	
	  		public static void main(String[] args)
	    {
	        try
	        {
	            // en  MAC O LINUX 
	            // Process p=Runtime.getRuntime().exec ("ls -R");
	        	
	            // Se lanza el ejecutable para Windows
	              Process p=Runtime.getRuntime().exec ("cmd /c dir");
	            
	            // Se obtiene el stream de salida del programa
	            InputStream is = p.getInputStream();
	            
	            // Se prepara un bufferedReader para poder leer la salida mas comodamente.
	            BufferedReader br = new BufferedReader (new InputStreamReader (is));
	            
	            // Se lee la primera linea
	            String aux = br.readLine();
	            
	            // Mientras se haya leido alguna linea
	            while (aux!=null)
	            {
	                // Se escribe la linea en pantalla
	                System.out.println (aux);
	                
	                // y se lee la siguiente.
	                aux = br.readLine();
	            }
	        } 
	        catch (Exception e)
	        {
	            // Excepciones si hay algún problema al arrancar el ejecutable o al
	            // leer su salida.
	            e.printStackTrace();
	        }
	
	    }
	    
	    
	}


