import java.rmi.Remote; 
import java.rmi.RemoteException;  
public interface ConversorBytes extends Remote { 
	public float mb(float num) throws RemoteException; 
    public float gb(float num) throws RemoteException;
    public float tb(float num) throws RemoteException;
    public float kb(float num) throws RemoteException;
} 

