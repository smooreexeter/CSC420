package test;

import java.util.Random;
import java.util.Scanner;

public class LListRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LList ll = new LList();
		Random r = new Random();
		for(int i = 0; i < 10; i++){
			ll.append("City " + i, r.nextInt(20), r.nextInt(20));
		}
		
		System.out.println(ll.displayLinkedList());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an x coordinate:");
		int x = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter a y coordinate:");
		int y = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter a range:");
		int range  = sc.nextInt();
		sc.nextLine();
		
		System.out.println(ll.arrayToString(ll.findByCoord(x, y, range)));
		
		System.out.println("Enter x coordinate to delete:");
		int delx = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter y coordinate to delete:");
		int dely = sc.nextInt();
		sc.nextLine();
		ll.deleteByCoord(delx, dely);
		
		System.out.println(ll.displayLinkedList());
	}

}
