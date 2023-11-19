
import java.util.concurrent.*;

class Ascensor implements Runnable{
	private final Semaphore s;
	private final String persona;
	
	Ascensor(Semaphore s, String persona){
		this.persona=persona;
		this.s=s;
	}
	
	
	public void run() {
		try{
			System.out.println("Llega: "+persona+"!");
			s.acquire();
			System.out.println("Ascensor disponible para "+persona+"!");
			Thread.sleep(5000);
			s.release();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		}

}

public class Edificio {

		public static void main(String args[]){
			Semaphore sem=new Semaphore(3, true);
			String personas[]={"Ramon","Marta","Ana","Jordi","Miguel","Kevin","Maria","Isabel","Hector"};
			Ascensor asc1[]=new Ascensor[personas.length];
			for(int i=0;i<personas.length;i++){
				asc1[i]=new Ascensor(sem,personas[i]);
				
				new Thread(asc1[i]).start();
			}
		}
	
}
