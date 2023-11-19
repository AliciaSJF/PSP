
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class BancoServer {

	public static void main(String[] args) throws RemoteException {
		try {
			Registry reg = LocateRegistry.createRegistry(5555);
			Banco banco = new BancoImpl();
			reg.rebind("Banco", banco);
			System.out.println("Servidor en marcha......");
		}catch(Exception e) {
			System.err.println("Error: " + e.toString());
			e.printStackTrace();
		}
	}
}
