import java.util.Random;
class Data {
  //almacena los datos
  //get obtiene  put lo pone
  int n;
  synchronized int get() {
    System.out.println("Obtengo: " + n);
    return n;
  }
  synchronized void put(int n) {
    this.n = n;
    System.out.println("Pongo: " + n);
  }
}
class Producer implements Runnable {
  //genera 10 numeros del 1 al 10
	Data q;
  Producer(Data q) {
    this.q = q;
    new Thread(this, "Productor").start();
  }
  public void run() {
    int i = 0;
    for (int j = 1; j <= 10; j++) {
    	/*try {
			Thread.sleep((int)(Math.random() * 100));
		} catch (InterruptedException e) {
		  }*/
      q.put(i++);
    }
  }
}
class Consumer implements Runnable {
 // consume los 10 numeros.
  Data q;
  Consumer(Data q) {
    this.q = q;
    new Thread(this, "Consumidor").start();
  }
  public void run() {
	  for (int j = 1; j <= 10; j++) {
		  /*try {
				Thread.sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {
			  }*/
      q.get();
    }
  }
}
class Pc1 {
  public static void main(String args[]) {
    Data q = new Data();
    new Producer(q);
    new Consumer(q);
   }
}
