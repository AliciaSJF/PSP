public class BancoDos {

	public static void main(String[] args) {
		CuentaDosOperaciones cuenta = new CuentaDosOperaciones(50);
		Operacion op1 = new Operacion(cuenta,0, "gasto", 75);
		Operacion op2 = new Operacion(cuenta,1, "gasto", 25);
		Operacion op3 = new Operacion(cuenta, 2,"ingreso", 50);
		Operacion op4 = new Operacion(cuenta, 3,"ingreso", 50);
		Operacion op5 = new Operacion(cuenta, 4,"gasto", 25);
		Operacion op6 = new Operacion(cuenta, 5,"gasto", 125);
		Operacion op7 = new Operacion(cuenta, 6,"ingreso", 100);
		Operacion op8 = new Operacion(cuenta, 7,"gasto", 25);
		Operacion op9 = new Operacion(cuenta,8,"gasto", 25);
		Operacion op10 = new Operacion(cuenta,9, "gasto", 25);
		op1.start();
		op2.start();
		op3.start();
		op4.start();
		op5.start();
		op6.start();
		op7.start();
		op8.start();
		op9.start();
		op10.start();
	}

}

class CuentaDosOperaciones {
	private int saldo;

	public CuentaDosOperaciones(int saldoInicial) {
		System.out.println("Nueva cuenta creada de valor  " + saldoInicial);
		this.saldo = saldoInicial;
		System.out.println("");
	}

	/*public  void ingreso(int cantidad) {
		System.out.println("Ingreso de: " + cantidad);
		saldo = saldo + cantidad;
		System.out.println("Nuevo saldo en cuenta de: " + this.saldo);
	}

	public void gasto(int cantidad) {
		System.out.println("Pido "+cantidad+" hay "+saldo);
		System.out.println("Gasto de: -" + cantidad);
		saldo = saldo - cantidad;
		System.out.println("Nuevo saldo en cuenta de: " + this.saldo);
		
	}*/
	public synchronized void ingreso(int cantidad) {
		System.out.println("Ingreso de: " + cantidad);
		saldo = saldo + cantidad;
		System.out.println("Nuevo saldo en cuenta de: " + this.saldo);
		notify();
	}

	public synchronized void gasto(int cantidad) {
		while (saldo-cantidad<0){
			try {
				System.out.println("Pido "+cantidad+" hay "+saldo);
				System.out.println("Duermo");
				wait();
				System.out.println("Despierto");
			} catch (InterruptedException e) {
				System.out.println("Error: error durmiendo hilo"+e);
			}
		}
		System.out.println("Gasto de: -" + cantidad);
		saldo = saldo - cantidad;
		System.out.println("Nuevo saldo en cuenta de: " + this.saldo);
		
	}
}


class Operacion extends Thread {

	CuentaDosOperaciones cuenta;
	int indice;
	String operacion;
	int cantidad;

	public Operacion(CuentaDosOperaciones cuenta, int indice,String operacion, int cantidad) {
		System.out.println("Operacion "+indice+": "+operacion+" cantidad: "+cantidad);
		this.cuenta = cuenta;
		this.operacion = operacion;
		this.cantidad = cantidad;
		this.indice=indice;
	}

	public void run() {
		switch (operacion) {
		case "ingreso":
			this.cuenta.ingreso(cantidad);
			break;
		case "gasto":
			this.cuenta.gasto(cantidad);
			break;

		default:
			break;
		}
	}
}
