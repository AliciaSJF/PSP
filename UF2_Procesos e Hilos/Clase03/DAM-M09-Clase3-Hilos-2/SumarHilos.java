import java.util.Random;
class SumaH implements Runnable{

	private String mensaje;
	private int suma=0, num;
	Random aleatorio = new Random();
	
	public SumaH(String msg) {
		this.mensaje=msg;
		System.out.println("--Tarea Iniciada");
		}
	
	public void run() {
			for (int i=0; i<20; i++ ) {
			num=aleatorio.nextInt(100);
			suma=suma+num;
			System.out.println(mensaje+"- número: "+ num + " - acumulado :"+ suma);
									}
		System.out.println("Suma finalizada "+suma);
	}
}
public class SumarHilos {

	public static void main (String[] args) {
		new Thread (new SumaH ("Suma 1")).start();
		new Thread (new SumaH ("Suma 2")).start();
		new Thread (new SumaH ("Suma 3")).start();
		new Thread (new SumaH ("Suma 4")).start();
	}
}

