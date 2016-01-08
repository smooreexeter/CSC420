package myLinkedList;
import java.util.LinkedList;
import java.util.Scanner;

public class Runner2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LList<String> ll = new LList<String>();
		ll.append("Star Wars");
		for(int i = 2; i < 6; i++){
			ll.append("" + i);
		}
		boolean addMore = true;
		while(addMore){
			System.out.println("Type the name of the DVD, or press enter to print the list.");
			String nameString = sc.nextLine();
			if(!nameString.isEmpty()){
				ll.append(nameString);
			} else{
				addMore = false;
			}
		}/*
		ll.moveToStart();
		System.out.print("[");
		for(int i = 0; i < ll.length(); i++){
			System.out.print(ll.getValue());
			if(i+1!=ll.length()){
				System.out.print(", ");
			}
			ll.next();
		}
		System.out.println("]");
		*/
		System.out.println(ll.toString());
	}

}
