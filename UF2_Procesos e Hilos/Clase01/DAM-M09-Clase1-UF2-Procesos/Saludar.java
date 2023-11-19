import java.io.IOException;

public class Saludar {
	public static final String RUTA = "C:\\tempjava\\";

	 public static void main(String[] args) {
		 System.out.println("Comienza el programa");
		 try {
		 Runtime.getRuntime().exec(RUTA + "mensaje.bat");
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 System.out.println("Fin del programa");
	 }
}
