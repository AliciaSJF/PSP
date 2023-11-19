import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.Scanner; 

public class ClienteBytes { 
	 
    public static void main(String[] args) { 
        
		try { 
         float numero, resultado=0;    
        // Obtenemos el registro
         Registry registry = LocateRegistry.getRegistry("localhost",5556); 
    
         // Buscamos en el registro el objeto remoto.
         ConversorBytes c = (ConversorBytes) registry.lookup("ConversorB"); 
		 // Pedimos los datos.
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Escribe una cantidad en bytes: ");
		 numero = Float.parseFloat(sc.nextLine());
		
		 // Llamamos al método del objeto remoto que hemos obtenido.
		 resultado=c.kb(numero);
         System.out.println( "En KB: "+String.valueOf(resultado) );
		 resultado=c.mb(numero);
         System.out.println( "En MB: "+String.valueOf(resultado) );
		 resultado=c.gb(numero);
         System.out.println( "En GB: "+String.valueOf(resultado) );
		 resultado=c.tb(numero);
         System.out.println( "En TB: "+String.valueOf(resultado) );
                 
         // System.out.println("Remote method invoked"); 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
	} 
}

