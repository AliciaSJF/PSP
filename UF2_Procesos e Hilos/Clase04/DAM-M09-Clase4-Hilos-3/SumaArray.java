import java.util.Random;
class Lista {
	private int valores[];
	private int numvalores;
	private int vacios,valor;
	Random aleatorio = new Random();
	Lista (int n){
		//n numero de elementos de nuestra lista
		//inicializamos a 0 la lista.
		numvalores=n;
		valores = new int[n];
		for (int i=0; i<numvalores; i++) {
			valores[i] = 0;
		}
		//cuantas posiciones estan vacias en la lista.
		vacios = numvalores;
	}
	synchronized public int poner(int hilo) throws 	InterruptedException {
		//añade un numero a la lista
		//si no quedan posiciones libres se espera
		int posicion=0;
		while (vacios == 0) {
			System.out.println(hilo + " esperando");
			wait();
		}
		//busca la primera posición libre
		while (valores[posicion] != 0) {
			posicion++;
		}
		valor=aleatorio.nextInt(10);
		valores[posicion] = valor;
		vacios--;
		return posicion;
	}
	synchronized public void calcular(int hilo) throws 	InterruptedException  {
		//si no se ha llenado la lista se espera
		while (vacios > 0) {
			System.out.println("--- Calculadora esperando ----");
			wait();
		}
		// suma los valores y volvemos a iniciar el proceso
		int suma=0;
		for (int i=0; i<numvalores; i++) {
			suma=suma+valores[i];
		}
		System.out.println("Hilo sumador: "+hilo+" La suma total és:" + suma);
		for (int i=0; i<numvalores; i++) {
			valores[i] = 0;
		}
		vacios = numvalores;
		imprimir();
		notify();
	}
	public void imprimir() {
		System.out.print("Valores: ");
		for (int i=0; i<numvalores; i++) {
			System.out.print("[" + valores[i] + "]" );
		}
		System.out.println("");
	}
}

class Sumar extends Thread {
	private static final int MAX_DELAY = 1000;
	private int id;
	private Lista l1;
	Sumar (int id, Lista listanum) {
		this.id = id;
		this.l1 = listanum;
	}

	public void run() {
		try {
			Thread.sleep(new Random().nextInt(MAX_DELAY));
			int numero = l1.poner(id);
			System.out.println("Hilo " + id + " ha guardado en la posición " + numero);
			l1.imprimir();
			l1.calcular(id);
			Thread.sleep(new  Random().nextInt(MAX_DELAY));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
public class SumaArray {
	private static final int numpos=5;
	private static final int numhilos=10;
	
	public static void main(String[] args) {
	
		//Inicializar el array
		Lista l = new Lista(numpos);

		Sumar hilos[] = new Sumar[numhilos];
		for (int i= 0; i < numhilos; i++){
			hilos[i]= new Sumar(i+1, l);
			hilos[i].start();
		}
		try {
			for (int i= 0; i < numhilos; i++){
				hilos[i].join();
			}
		} catch (InterruptedException ex) {
			System.out.println("Hilo principal interrumpido.");
		}
	}
}

