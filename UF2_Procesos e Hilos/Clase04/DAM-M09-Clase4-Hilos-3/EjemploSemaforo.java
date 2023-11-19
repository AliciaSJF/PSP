import java.util.concurrent.Semaphore;

 class Semaforo implements Runnable {
 
    //  Número de  procesos que se pueden ejecutar al tiempo.
    private static final Semaphore DISPONIBILIDAD = new Semaphore(2);
    //nombre del proceso
    private final String nombre;
     
    public Semaforo(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        try {
            // Solicita disponibilidad.
            DISPONIBILIDAD.acquire();
             System.out.println("El proceso [ " + this.nombre + " ] dormira " +
                " 5 segundos");
             Thread.sleep(5000);
             System.out.println("Finaliza el proceso [ " + this.nombre + " ]");
             // Libera disponibilidad.
            DISPONIBILIDAD.release();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
public class EjemploSemaforo {
	public static void main(String[] args) {
        // Ejecutamos 10 procesos.
        for (int i = 0; i < 10; i++) {
            new Thread(new Semaforo("Proceso #" + i)).start();
        }      
    }
}
