package myLinkedList;

import java.util.Scanner;

public class LQueueRunner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LQueue lq = new LQueue();
		for(int i = 0; i < 10; i++){
			lq.enqueue("" + i);
		}
		lq.enqueueFront("bob");
		
		boolean done = false;
		while(!done){
			System.out.println("Please enter a new value or press enter to print the list.");
			String input = sc.nextLine();
			if(!input.isEmpty()){
				System.out.println("Enter f or r to add to the front or rear.");
				String fr = sc.nextLine();
				boolean isCorrect = false;
				while(!isCorrect){
					if(!fr.equals("f") && !fr.equals("r")){
						System.out.println("Enter f or r");
						fr = sc.nextLine();
					}else{
						isCorrect = true;
					}
				}
				if(fr.equals("r")){
					lq.enqueue(input);
				}else{
					lq.enqueueFront(input);
				}
			}else{
				done = true;
			}
		}
		int len = lq.length();
	
		for(int i = 0; i < len; i++){
			System.out.println(lq.dequeueRear());
		}
	}

}
