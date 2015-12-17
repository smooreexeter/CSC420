package project;

import java.util.LinkedList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		LinkedList<Contact> contacts = new LinkedList<Contact>();
		Scanner sc = new Scanner(System.in);
		int selection1 = 1;
		while(selection1 != 0){	
			System.out.println("Welcome to Contacts!\nChoose the number of the desired action\n1) Create new contact\n2) View address book\n3) Edit address book\n\n0) Quit");
			selection1 = sc.nextInt();
			if(selection1 == 1){
				System.out.println("Would you like to create a:\n1) Personal contact\n2) Business contact");
				int selection2 = sc.nextInt();
				while(selection2 != 1 && selection2 != 2 && selection2 != 0){
					System.out.println("Please choose either 1 or 2, or press 0 to return to the main menu\n1) Personal contact\n2) Business contact");
					selection2 = sc.nextInt();
				}
				if(selection2 == 1){
					String[] info = new String[7];
					String indexText;
					System.out.println("Enter an index, or press enter to go to the next available index");
					indexText = sc.nextLine();
					sc.nextLine();
					System.out.println("ID:");
					info[0] = sc.nextLine();
					System.out.println("First Name:");
					info[1] = sc.nextLine();
					System.out.println("Last Name:");
					info[2] = sc.nextLine();
					System.out.println("Address:");
					info[3] = sc.nextLine();
					System.out.println("Phone Number:");
					info[4] = sc.nextLine();
					System.out.println("Email:");
					info[5] = sc.nextLine();
					System.out.println("Birthday:");
					info[6] = sc.nextLine();
					int index;
					if(indexText.equals("")){
						index = contacts.size();
					}else{
						index = Integer.parseInt(indexText);
					}
					contacts.add(index, new PersonalContact(info[0], info[1], info[2], info[3], info[4], info[5], info[6]));
				}else if(selection2 == 2){
					String[] info = new String[9];
					String indexText;
					System.out.println("Enter an index, or press enter to go to the next available index");
					indexText = sc.nextLine();
					sc.nextLine();
					System.out.println("ID:");
					info[0] = sc.nextLine();
					System.out.println("First Name:");
					info[1] = sc.nextLine();
					System.out.println("Last Name:");
					info[2] = sc.nextLine();
					System.out.println("Address:");
					info[3] = sc.nextLine();
					System.out.println("Phone Number:");
					info[4] = sc.nextLine();
					System.out.println("Email:");
					info[5] = sc.nextLine();
					System.out.println("Birthday:");
					info[6] = sc.nextLine();
					System.out.println("Job Title:");
					info[7] = sc.nextLine();
					System.out.println("Organization:");
					info[8] = sc.nextLine();
					int index;
					if(indexText.equals("")){
						index = contacts.size();
					}else{
						index = Integer.parseInt(indexText);
					}
					contacts.add(index, new BusinessContact(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]));

				}
				
			}else if(selection1 == 2){
				System.out.println("\n\n");
				for(int i = 0; i < contacts.size(); i++){
					System.out.println(contacts.get(i).toString());
				}
				System.out.println("\n\nPress 0 to return to the main menu");
				int quit=sc.nextInt();
				while(quit!=0){
					quit=sc.nextInt();
				}
			}else if(selection1 == 3){
				
			}
		}
	}

}
