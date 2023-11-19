import java.io.IOException;

public class SaludarEsperar {
	public static final String RUTA = "C:\\tempjava\\";

	 public static void main(String[] args) {
	 System.out.println("Comienza el programa");
	 try {
	 Process p = Runtime.getRuntime().exec(RUTA + "mensaje2.bat");
	 p.waitFor();
	 } catch (IOException e) {
	 e.printStackTrace();
	 } catch (InterruptedException e) {
	 e.printStackTrace();
	 }
	 System.out.println("Fin del programa");
	 }
}
