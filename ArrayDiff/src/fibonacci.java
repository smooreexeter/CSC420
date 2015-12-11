import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n: ");
		System.out.println(fibonacci(scan.nextInt()));
		
	}
	
	public static int fibonacci(int n){
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else {
			return fibonacci(n-1)  + fibonacci(n-2);
		}
	}

}
