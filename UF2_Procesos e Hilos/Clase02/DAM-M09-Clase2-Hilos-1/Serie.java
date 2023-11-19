public class Serie extends Thread
{

 private double sup;
 private double inf;
 private double i;
 private double suma=0;

  Serie(double a,double b){
	  inf=a;
	  sup=b;
	  System.out.println(inf);
	  System.out.println(sup);
  }

public void run(){
	for(i=inf;i<=sup;i++){
		suma=suma+i;
		System.out.println("Hilo--> "+this.getName()+ " i = " + i + " Suma= " + suma);
		}
	}
public static void main(String args[]){
	Serie h1=new Serie(2,5);
	h1.setName("Uno");
	Serie h2=new Serie(5,10);
	h2.setName("Dos");
	h1.start();
	h1.setPriority(MAX_PRIORITY);
	h2.start();
	h2.setPriority(MIN_PRIORITY);
	}
}
