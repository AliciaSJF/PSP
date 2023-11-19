class Datos {
  int n;
  boolean hayValores = false;
  synchronized int get() {
	 if(!hayValores)
      try {
    	     wait();
      } catch(InterruptedException e) {
        System.out.println("InterruptedException capturada");
      }
    System.out.println("Obtengo: " + n);
    hayValores = false;
    notify();
    return n;
  }
  synchronized void put(int n) {
    if(hayValores)
      try {
        wait();
      } catch(InterruptedException e) {
        System.out.println("InterruptedException capturada");
      }
    this.n = n;
    hayValores = true;
    System.out.println("Pongo: " + n);
    notify();
  }
}
class Productor implements Runnable {
  Datos q;
  Productor(Datos q) {
    this.q = q;
    new Thread(this, "Productor").start();
  }
  public void run() {
    int i = 0;
    for (int j = 1; j <= 10; j++) {
      q.put(i++);
    }
  }
}
class Consumidor implements Runnable {
  Datos q;
  Consumidor(Datos q) {
    this.q = q;
    new Thread(this, "Consumidor").start();
  }
  public void run() {
	  for (int j = 1; j <= 10; j++) {
      q.get();
    }
  }
}
class Pcfixed {
  public static void main(String args[]) {
    Datos q = new Datos();
    new Productor(q);
    new Consumidor(q);
     }
}
