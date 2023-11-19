package ampliacio;
import java.math.BigInteger;
public class Factorial {

	public static void main(String[] args) throws InterruptedException {
		
		 final int n =100000;
		 long timeStart = System.currentTimeMillis();        
		 BigInteger result = BigInteger.ONE;
		 for(int i =2; i <= n; i++)
		 	{            
			 result = result.multiply(BigInteger.valueOf(i));
			 }
		 long timeEnd = System.currentTimeMillis();        
		 System.out.printf("Resultado = %d, Tiempo = %.4f%n", result.bitCount(),(timeEnd - timeStart)/1000.0);
		 }
}

