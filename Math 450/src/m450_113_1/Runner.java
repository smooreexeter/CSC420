package m450_113_1;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("n:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(5));
		double sumr = 0;
		double sumt = 0;
		double rat = 0;
		double test = 0;
		for(int i = 0; i <= n; i++){
			System.out.println(i);
			System.out.println("pow: " + Math.pow(10, i));
			System.out.println("fac: " + factorial(i));
			rat = Math.pow(10, i)/factorial(i);
			sumr += rat;
			System.out.println("---ratio: " + rat);
			test = 1/Math.pow(2, i);
			sumt += test;
			System.out.println("+++1/2^n ratio: " + test);
			if(test < rat){
				System.out.println("passed " + (sumr - sumt));
			}
			System.out.println("sum: " + sumr);
		}
	}
	
	public static double factorial(long a){
		double ret = 1;
		for(int i = 1; i <= a; i++){
			ret *= i;
		}
		return ret;
	}

}
