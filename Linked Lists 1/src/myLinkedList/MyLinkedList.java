package myLinkedList;

public class MyLinkedList {
	String data;
	MyLinkedList next;
	
	public MyLinkedList(String data, MyLinkedList next){
		this.data = data;
		this.next = next;
	}
	
	public String toString(){
		return data;
	}
	
}
