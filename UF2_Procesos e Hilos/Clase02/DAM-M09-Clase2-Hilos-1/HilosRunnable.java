public class HilosRunnable {
 
	static public void main( String args[] ) {
	 
		// Se instancian dos nuevos objetos Thread
        Thread hiloA = new Thread( new MiHilo());
        Thread hiloB = new Thread( new MiHilo());

        // Se arrancan los dos hilos, para que comiencen su ejecución
        hiloA.start();
         
        //Miramos si todavia el hiloA esta vivo
        System.out.println("¿El hiloA sigue vivo?:"+hiloA.isAlive());
        hiloB.start();
        hiloA.setName("HILO_A");
        hiloA.setPriority(1);
        hiloB.setPriority(Thread.MAX_PRIORITY);
        // Aqui se retrasa la ejecucion dos segundos y se captura la
        // posible excepción que genera el método, aunque no se hace
        // nada en el caso de que se produzca
        try {
            Thread.currentThread();
            Thread.sleep( 2000 );
        }catch( InterruptedException e ){}  

    
        //Visualizamos el nombre asignado al hiloA
        System.out.println("Nombre del hiloA:"+ hiloA.getName());
        
        //Asignamos la minima prioridad al HiloB
        hiloB.setPriority(Thread.MIN_PRIORITY);
        
        // Presenta informacion acerca del Thread o hilo principal del programa
        System.out.println( Thread.currentThread() );
        //Visualizamos la el nombre del hiloA
        System.out.println("Nombre del hiloA:"+ hiloA.getName());
  
        //Visualizamos las prioridades asignadas a los hilos
        System.out.println("Prioridad del hiloA:"+ hiloA.getPriority());
        System.out.println("Prioridad del hiloB:"+ hiloB.getPriority());
      //Miramos si todavía el hiloA esta vivo
        System.out.println("¿El hiloA sigue vivo?:"+hiloA.isAlive());
  
	} 
  } 


class MiHilo  implements Runnable {
     public void run() {
         // Presenta en pantalla informacion sobre este hilo en particular
        System.out.println( Thread.currentThread() );
    	
    }
  }

