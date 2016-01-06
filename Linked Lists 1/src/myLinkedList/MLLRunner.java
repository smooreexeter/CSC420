package myLinkedList;

public class MLLRunner {

	public static void main(String[] args) {

		MyLinkedList dvd2 = new MyLinkedList("Interstellar", null);
		MyLinkedList dvd1 = new MyLinkedList("Star Wars", dvd2);
		System.out.println(dvd1.toString());

	}

}
