package myLinkedList;
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
		}
		System.out.println(ll.displayLinkedList());
		alpha(ll);
		System.out.println(ll.displayLinkedList());
		sc.close();
	}

	public static void alpha(LList<String> ll){
		ll.moveToStart();
		for(int i = 0; i < ll.length()-1; i++){
			String s1 = ll.getValue();
			ll.next();
			if(ll.currPos() < ll.length()){
				String s2 = ll.getValue();
				System.out.println("run1");
				System.out.println(s1 + " " +s2);
				if(s1.compareTo(s2) > 0){
					i -= 2;
					ll.prev();
					ll.insert(s2);
					ll.next();
					ll.next();
					ll.remove();
					System.out.println("run2");
					ll.prev();
				}
			
			}
		}
	}
	
}
