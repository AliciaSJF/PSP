public class Banco {

	public static void main(String[] args) {
		Cuenta cuenta = new Cuenta(50);
		Operar op1 = new Operar(cuenta, 100);
		Operar op2 = new Operar(cuenta, -50);
		Operar op3 = new Operar(cuenta, 200);
		Operar op4 = new Operar(cuenta, -75);

	}

}

class Cuenta {
	private int saldo;

	public Cuenta(int saldoInicial) {
		System.out.println("Nueva cuenta creada de valor  " + saldoInicial);
		this.saldo = saldoInicial;
	}
	
	// falta que el método sea sincronizado.
	
	public synchronized void operar(int cantidad) {
		System.out.println("Movimiento de: " + cantidad);
		saldo = saldo + cantidad;
		System.out.println("Nuevo saldo en cuenta de: " + this.saldo);
	}
}

class Operar implements Runnable {
	Cuenta cuenta;
	int cantidad;

	public Operar(Cuenta cuenta, int cantidad) {
		this.cuenta = cuenta;
		this.cantidad = cantidad;
		new Thread(this).start();
	}

	public void run() {
		this.cuenta.operar(cantidad);

	}
}
