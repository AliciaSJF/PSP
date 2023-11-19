public class EjemploJoin extends Thread {

	 private String mensaje;
	 
	 EjemploJoin (String msg) {
	  mensaje = msg; 
	   }

	public void run () {

	 for (int i = 1; i <=5; i++)
	 System.out.println (mensaje + " " + i);
	 System.out.println ("Fin Hilo " + mensaje);
	 }

	public static void main (String args[]) {

	 System.out.println ("Inicio programa principal");
	 EjemploJoin h1=new EjemploJoin("Alumno Joan");
	 EjemploJoin h2=new EjemploJoin("Alumno Ana");
	 System.out.println ("Inicio Alumno Joan");
	 h1.start();
	 System.out.println ("Inicio Alumno Ana");
	 h2.start();
	 try {
		h1.join();
        h2.join();
    }catch( InterruptedException e ){}  
	 System.out.println ("Fin programa principal");
	 }
}