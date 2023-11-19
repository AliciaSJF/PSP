class Dispositivo {
   void escribir (String msg) {   
    System.out.print("<h1>" + msg);
    try {
      Thread.sleep(1000);
    } catch(InterruptedException e) {
      System.out.println("Interrumpido");
    }
    System.out.println("</h1>");
  }
}
class Mostrar implements Runnable {
  String msg;
  Dispositivo pantalla;
  Thread t;
  public Mostrar(Dispositivo targ, String s) {
    pantalla = targ;
    msg = s;
    t = new Thread(this);
    t.start();
  }
  public void run() {
	          	pantalla.escribir(msg);
	    }
}
class EscribirS {
  public static void main(String args[]) {
    Dispositivo disp = new Dispositivo();
    Mostrar ob1 = new Mostrar(disp, "Que la fuerza te acompañe");
    Mostrar ob2 = new Mostrar(disp, "Teléfono, mi casa ..");
    Mostrar ob3 = new Mostrar(disp, "Elemental querido watson");
    Mostrar ob4 = new Mostrar(disp, "Sayonara baby");
    
    try {
      ob1.t.join();
      ob2.t.join();
      ob3.t.join();
      ob4.t.join();
    } catch(InterruptedException e) {
      System.out.println("Interrumpido");
    }
  }
}