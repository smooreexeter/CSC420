import java.lang.reflect.Array;
import java.util.Scanner;

public class arrayDiffRunner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many numbers will you enter?");
		int arraySize = scan.nextInt();
		System.out.println("Enter " + arraySize + " numbers separated by spaces:");
		int[] input = new int[arraySize];
		for(int i = 0; i < arraySize; i++){
			input[i]=Integer.parseInt(scan.next());
		}
		
		System.out.println("Clumps: " + arrayDiff.clump(input));
	}

}
