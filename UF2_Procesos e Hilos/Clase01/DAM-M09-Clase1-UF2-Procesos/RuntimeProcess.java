public class RuntimeProcess {
	public static void main(String[] args) {
		Runtime Objrun = Runtime.getRuntime(); // creación de un objeto get.Runtime
		
		try
		{
        Process Objprocess = Objrun.exec("C:\\Program Files (x86)\\Dia\\bin\\Dia.exe");
        Objprocess.destroy();
        System.out.println("Proceso destruido");
		}
		catch(Exception e)
		{
        System.out.println("Error executing program");
		}
	}
}