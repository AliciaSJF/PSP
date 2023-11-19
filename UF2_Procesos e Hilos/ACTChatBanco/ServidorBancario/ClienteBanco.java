
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class ClienteBanco {
	
	
	
	
	public static void main(String[] args) {
		try {
			double cantidad, tasa;
			int tiempo;
			double resultado = 0;
			Scanner sc = new Scanner(System.in);
			String opcion="";
			
			
			Registry reg = LocateRegistry.getRegistry("localhost", 5555);
			Banco b = (Banco)reg.lookup("Banco");
			System.out.println("Cliente conectado...");
			System.out.println("Pulse una tecla...");
			while(!opcion.equals("fin")) {
				cantidad = 0;
				opcion= sc.nextLine();
				System.out.println("Opciones");
				System.out.println("--------");
				System.out.println("D -> Convertir a dolares");
				System.out.println("Y -> Convertir a yenes");
				System.out.println("P -> convertir a pesos");
				System.out.println("L -> Convertir a libras");
				System.out.println("I -> Interes Simple");
				System.out.println("C -> Interes Compuesto");
				System.out.print("Opcion: ");
				opcion= sc.nextLine();
				if(!opcion.equals("fin")) {
					System.out.print("Cantidad: ");
					cantidad = sc.nextDouble();
					switch(opcion) {
						case "D":
							resultado = b.convertirDolares(cantidad);
							System.out.println("La cantidad de " + cantidad + " � son " + resultado + " $");
							break;
						case "Y":
							resultado = b.convertirYenes(cantidad);
							System.out.println("La cantidad de " + cantidad + " � son " + resultado + " �");
							break;
						case "P":
							resultado = b.convertirPesos(cantidad);
							System.out.println("La cantidad de " + cantidad + " � son " + resultado + " $ (Pesos)");
							break;
						case "L":
							resultado = b.convertirLibras(cantidad);
							System.out.println("La cantidad de " + cantidad + " � son " + resultado + " �");
							break;
						case "I":
							System.out.print("Tasa: ");
							tasa = sc.nextDouble();
							System.out.print("Tiempo: ");
							tiempo=sc.nextInt();
							resultado = b.interesSimple(cantidad,tasa,tiempo);
							System.out.println("El interes simple es: " + resultado);
							break;
						case "C":
							System.out.print("Tasa: ");
							tasa = sc.nextDouble();
							System.out.print("Tiempo: ");
							tiempo=sc.nextInt();
							resultado = b.interesCompuesto(cantidad,tasa,tiempo);
							System.out.println("El interes simple es: " + resultado);
							break;
						default:
							System.out.println("No es una opcion valida");
					}
				}
			}
			System.out.println("Fin de programa");
		}catch(Exception e) {
			
		}
	}
	
	
	public static void menuPrincipal() {
		
		
	}

}
