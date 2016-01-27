package m450_113_1;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("n:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(5));
		for(int i = 0; i <= n; i++){
			System.out.println(i);
			System.out.println("pow: " + Math.pow(10, i));
			System.out.println("fac: " + factorial(i));
			System.out.println("---ratio: " + ((long) Math.pow(10, i)/(long) factorial(i)));
		}
	}
	
	public static double factorial(long a){
		long ret = 1;
		for(int i = 1; i <= a; i++){
			ret *= i;
		}
		return ret;
	}

}
