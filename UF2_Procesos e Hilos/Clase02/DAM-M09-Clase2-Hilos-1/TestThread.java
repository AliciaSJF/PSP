class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;
	
	//constructor->inicialización
	RunnableDemo( String name){
		threadName = name;
		System.out.println("Creando " + threadName );
	}
	//código que ejecutan los hilos
	public void run() {
		System.out.println("Running " + threadName );
		try {
			for(int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// para dormir el thread
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrumpido.");
		}
		System.out.println("Thread " + threadName + " finalizado.");
	}
	
	public void start (){
		System.out.println("Iniciando " + threadName );
		if (t == null)
		{
			t = new Thread (this, threadName);
			t.start ();
		}
	}
}
public class TestThread {
	 public static void main(String args[]) {
	 RunnableDemo r1 = new RunnableDemo("Hilo 1");
	 r1.start();
	 RunnableDemo r2 = new RunnableDemo("Hilo 2");
	 r2.start();
	 }
}

