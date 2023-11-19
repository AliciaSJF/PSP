import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class ServidorBytes {

 public static void main(String args[]) throws RemoteException{ 
         try { 
		 // Creamos el registro
         Registry registry = LocateRegistry.createRegistry(5556); 
         // Instanciamos la implementación de la classe.
         ConversorBytes obj = new ConversorBytesImpl(); 
         // Exportamos el objeto de la classe implementada. 
         // (Aquí exportamos el objeto al stub) 
         registry.rebind("ConversorB", obj);  
         
         System.err.println("Servidor en linea ...."); 
      } catch (Exception e) { 
         System.err.println("Error de Servidor: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}


