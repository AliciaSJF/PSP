import java.rmi.*;
import java.rmi.server.*;
//Implementamos la interfaz remota. 
public class ConversorBytesImpl extends UnicastRemoteObject implements ConversorBytes  { 
 
    // Debe tener un constructor con RemoteException exception 

    public ConversorBytesImpl() throws RemoteException {
		super();
		}
    public float mb(float num) throws RemoteException {
        return kb(num)/1000; 
    }  
    public float gb(float num) throws RemoteException {
        return mb(num)/1000; 
    } 
    public float tb(float num) throws RemoteException {
        return gb(num)/1000; 
    } 
    public float kb(float num) throws RemoteException {
        return num/1000; 
    } 
}
