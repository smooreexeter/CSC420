package project;

import java.util.LinkedList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<String>();
		list.add("place1");
		list.add("place2");
		list.add("place3");
		System.out.println(list.size());
		list.remove(1);
		System.out.println(list.size());
	}

}
