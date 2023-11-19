package ampliacio;
import java.math.BigInteger;
public class FactorialHilos implements Runnable {

	private int start, end;
	private BigInteger result = BigInteger.ONE;
	
	public FactorialHilos(int start,int end) {
		this.start= start;
		this.end= end;
	}
	public void run(){
		for(int i = start; i <= end; i++) { 
			result = result.multiply(BigInteger.valueOf(i));
		}
	}
	public static void main(String[] args) throws InterruptedException {

			final int n =100000;
			long timeStart = System.currentTimeMillis();        
			FactorialHilos p1 =new FactorialHilos(2, n /2);        
			FactorialHilos p2 =new FactorialHilos(n /2+1, n);        
			Thread t1 =new Thread(p1);        
			Thread t2 =new Thread(p2);        
			t1.start();        
			t2.start();        
			t1.join();        
			t2.join();        
			BigInteger total = p1.result.multiply(p2.result);
			long timeEnd = System.currentTimeMillis();        
			System.out.printf("Resultado = %d, Tiempo = %.4f%n", total.bitCount(),(timeEnd - timeStart)/1000.0);
	}
}