
import java.rmi.*;
import java.rmi.server.*;

public class BancoImpl extends UnicastRemoteObject implements Banco {
		
		public BancoImpl() throws RemoteException {
			super();
		}
		
		public double convertirDolares(double cantidad) throws RemoteException {
			cantidad  = cantidad * 1.11;
			return cantidad;
		}
		
		public double convertirYenes(double cantidad) throws RemoteException {
			cantidad = cantidad * 124.75;
			return cantidad;
		}
		
		public double convertirPesos(double cantidad) throws RemoteException {
			cantidad = cantidad * 21.15;
			return cantidad;
		}
		
		public double convertirLibras(double cantidad) throws RemoteException {
			cantidad = cantidad * 0.86;
			return cantidad;
		}
		
		public double interesSimple(double cantidad, double tasa, int tiempo) throws RemoteException {
			cantidad = cantidad*(tasa/100)*tiempo;
			return cantidad;
		}
		
		public double interesCompuesto(double cantidad, double tasa, int tiempo) throws RemoteException {
			cantidad = cantidad*(1+(tasa/100))*tiempo;
			return cantidad;
		}
	
}
