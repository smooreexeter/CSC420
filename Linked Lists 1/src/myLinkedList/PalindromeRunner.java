package myLinkedList;

import java.util.Scanner;

public class PalindromeRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*LStack<String> ls = new LStack<String>();
		LQueue<String> lq = new LQueue<String>();
		
		Scanner sc = new Scanner(System.in);
		boolean finished = false;
		
		while(!finished){
			System.out.println("Input a letter or press enter to evaluate.");
			String input = sc.nextLine().toUpperCase();
			if(!input.isEmpty()){
				ls.push(input);
				lq.enqueue(input);
			}else{
				finished = true;
			}
		}
		boolean isPal = true;
		for(int i = 0; i < lq.length(); i++){
			if(!ls.pop().equals(lq.dequeue())){
				isPal = false;
			}
		}
		System.out.println(isPal);*/
		
		
		System.out.println("Enter String.");
		Scanner sc2 = new Scanner(System.in);
		System.out.println(StringIsPalindrome(sc2.nextLine()));
	}
	
	public static boolean StringIsPalindrome(String st){
		boolean isPal = true;
		st = st.toUpperCase();
		LStack<String> ls = new LStack<String>();
		LQueue<String> lq = new LQueue<String>();
		for(int i = 0; i < st.length(); i++){
			ls.push(st.substring(i, i+1));
			lq.enqueue(st.substring(i, i+1));
		}
		for(int i = 0; i < lq.length(); i++){
			if(!ls.pop().equals(lq.dequeue())){
				isPal = false;
			}
		}
		return isPal;
	}

}
