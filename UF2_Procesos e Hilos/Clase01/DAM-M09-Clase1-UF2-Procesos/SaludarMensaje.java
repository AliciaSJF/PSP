import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaludarMensaje {

	public static final String RUTA = "C:\\tempjava\\";

		 public static void main(String[] args) {
		 System.out.println("Comienza el programa");
		 try {
		 Process p = Runtime.getRuntime().exec(RUTA + "mensaje.bat");

		 BufferedReader output = new BufferedReader(new InputStreamReader(
		 p.getInputStream()));
		 BufferedReader error = new BufferedReader(new InputStreamReader(
		 p.getErrorStream()));
		 String texto = "";

		 while ((texto = output.readLine()) != null) {
		 System.out.println(texto);
		 }

		 while ((texto = error.readLine()) != null) {
		 System.out.println(texto);
		 }

		 p.waitFor();
		 } catch (IOException e) {
		 e.printStackTrace();
		 } catch (InterruptedException e) {
		 e.printStackTrace();
		 }
		 System.out.println("Fin del programa");
		 }
	}


