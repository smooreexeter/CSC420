package m450_113_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("n:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(5));
		BigDecimal rat = new BigDecimal("0.0");
		BigDecimal test = new BigDecimal("1");
		BigDecimal last = new BigDecimal("1");
		BigDecimal ten = new BigDecimal("1");
		BigDecimal fac;
		for(int i = 0; i <= n; i++){
			fac = factorial(i);
			System.out.println(i);
			System.out.println("pow: " + ten.toString());
			System.out.println("fac: " + fac.toString());
			rat = ten.divide(fac, 1000, RoundingMode.HALF_UP);
			ten = ten.multiply(BigDecimal.TEN);
			System.out.println("---10^n/n!: " + rat.stripTrailingZeros().toString());
			test = test.multiply(new BigDecimal("0.5"));
			System.out.println("+++1/2^n: " + test);
			if(test.compareTo(rat)>0){
				System.out.println("passed");
			}
			System.out.println("~~~Ratio n+1/n: " + rat.divide(last, 1000, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
			last = rat;
		}
		sc.close();
	}
	
	public static BigDecimal factorial(int a){
		BigDecimal ret = new BigDecimal("1.0");
		BigDecimal in;
		for(int i = 1; i <= a; i++){
			in = new BigDecimal(Integer.toString(i));
			ret = ret.multiply(in);
		}
		return ret;
	}

}