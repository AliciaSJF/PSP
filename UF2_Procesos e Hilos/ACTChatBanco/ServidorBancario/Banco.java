import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Banco extends Remote {

	public double convertirDolares(double cantidad) throws RemoteException;
	public double convertirYenes(double cantidad) throws RemoteException;
	public double convertirPesos(double cantidad) throws RemoteException;
	public double convertirLibras(double cantidad) throws RemoteException;
	public double interesSimple(double cantidad, double tasa, int tiempo) throws RemoteException;
	public double interesCompuesto(double cantidad, double tasa, int tiempo) throws RemoteException;
	
}
