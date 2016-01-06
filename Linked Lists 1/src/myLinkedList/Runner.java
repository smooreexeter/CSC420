package myLinkedList;
import java.util.LinkedList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		Scanner sc = new Scanner(System.in);
		LinkedList<MyLinkedList> mll = new LinkedList<MyLinkedList>();
		mll.add(new MyLinkedList("Star Wars", null));
		boolean addMore = true;
		while(addMore){
			System.out.println("Type the name of the DVD, or press enter to print the list.");
			String nameString = sc.nextLine();
			if(!nameString.isEmpty()){
				mll.add(new MyLinkedList(nameString, mll.get(mll.size()-1)));
			} else{
				addMore = false;
			}
		}
		System.out.print("[");
		for(int i = 0; i < mll.size(); i++){
			System.out.print(mll.get(i).toString());
			if(i+1!=mll.size()){
				System.out.print(", ");
			}
		}
		System.out.println("]");
		//System.out.println(mll.toString());

	}

}
