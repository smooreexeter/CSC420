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
				int quit = sc.nextInt();
				while(quit!=0){
					quit = sc.nextInt();
				}
			}else if(selection1 == 3){
				System.out.println("What index would you like to edit?");
				int index = sc.nextInt();
				boolean retry = true;
				if(!contacts.isEmpty()){
					while(retry){
						if(index >= 0 && index <contacts.size()){
							if(contacts.get(index).getType()==0){
								System.out.println("Which field would you like to edit?\n1) ID\t\t2) First Name\n3) Last Name\t"
										+ "4) Address\n5) Phone Number\t6) Email\n7) Birthday");
								int field = sc.nextInt();
								System.out.println("That field is currently set to " + contacts.get(index).getInfo(field) + ". Enter your change, or press enter to cancel.");
								sc.nextLine();
								String change = sc.nextLine();
								System.out.println(change);
								if(!change.equals("")){
									contacts.get(index).changeInfo(field, change);
									System.out.println("Changed!");
								}
								System.out.println("Would you like to make another change?\n1) Yes\n2) No");
								String again = sc.nextLine();
								again = again.toLowerCase();
								while(!again.equals(1) && !again.equals(2) && !again.equals('y') && !again.equals('n')){
									System.out.println("Please enter either 1 or 2.\n1) Yes\n2) No");
									again = sc.nextLine();
								}
								if(again.equals(1) || again.equals('y')){
									retry=true;
								}else{
									retry = false;
								}
							}
							
							if(contacts.get(index).getType()==1){
								System.out.println("Which field would you like to edit?\n1) ID\t\t2) First Name\n3) Last Name\t"
										+ "4) Address\n5) Phone Number\t6) Email\n7) Birthday\t8) Job Title\n9) Organization");
								int field = sc.nextInt();
								System.out.println("That field is currently set to " + contacts.get(index).getInfo(field) + ". Enter your change, or press enter to cancel.");
								sc.nextLine();
								String change = sc.nextLine();
								if(!change.equals("")){
									contacts.get(index).changeInfo(field, change);
								}
								System.out.println("Would you like to make another change?\n1) Yes\n2) No");
								String again = sc.nextLine();
								again = again.toLowerCase();
								while(!again.equals(1) && !again.equals(2) && !again.equals('y') && !again.equals('n')){
									System.out.println("Please enter either 1 or 2.\n1) Yes\n2) No");
									again = sc.nextLine();
								}
								if(again.equals(1) || again.equals('y')){
									retry=true;
								}else{
									retry = false;
								}
							}
						} else{
							System.out.println("That index doesn't exist. Please enter a number from 0 to " + (contacts.size()-1) + ".");
							retry = true;
						}
					}
				}
			}
		}
	}

}
