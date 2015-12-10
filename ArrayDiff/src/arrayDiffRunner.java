import java.lang.reflect.Array;
import java.util.Scanner;

public class arrayDiffRunner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter four numbers separated by spaces:");
		int[] input = new int[4];
		for(int i = 0; i < 4; i++){
			input[i]=Integer.parseInt(scan.next());
		}
		
		System.out.println(arrayDiff.bigDiff(input));
	}

}
