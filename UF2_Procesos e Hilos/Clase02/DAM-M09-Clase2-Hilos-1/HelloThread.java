class HelloHilo extends Thread {

	public void run() {
		System.out.println("Hola desde el hilo creado!");
	}
}

public class HelloThread {
	public static void main(String args[]) {
		
	HelloHilo h1= new HelloHilo();// Crea y arranca un nuevo hilo de ejecución
	h1.start();
 	System.out.println("Hola desde el hilo principal!");
	System.out.println("Proceso acabando.");
	}
}
