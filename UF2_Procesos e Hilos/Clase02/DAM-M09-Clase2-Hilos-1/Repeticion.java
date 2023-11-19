
public class Repeticion extends Thread {

	 private int repeticiones;
	 private String mensaje;
	 
	 Repeticion (String msg, int n) {
	  mensaje = msg; 
	  repeticiones = n;
	  }

	public void run () {

	 for (int i = 1; i <= repeticiones; i++)
	 System.out.println (mensaje + " " + i);
	 }

	public static void main (String args[]) {

	 Repeticion r1=new Repeticion("Rojo", 5);
	 Repeticion r2=new Repeticion("Azul", 10);
	 r1.start();
	 r2.start ();
	 }
	}
