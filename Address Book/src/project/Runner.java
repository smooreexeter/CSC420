package project;

import java.util.LinkedList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
		LinkedList<Contact> contacts = new LinkedList<Contact>();
		Scanner sc = new Scanner(System.in);
		String selection1String = "";
		int selection1 = 1;
		while(!(selection1 == 0)){	
			//menu
			System.out.println("Welcome to Contacts!\nChoose the number of the desired action\n1) Create new contact\t2) Edit address book\n"
					+ "3) View address book\t4) View one contact\n\n0) Quit");
			selection1String = sc.nextLine();
			//make sure it is assigned if it isn't an integer from 0 to 4
			while(!selection1String.equals("1") && !selection1String.equals("2") && !selection1String.equals("3") && !selection1String.equals("4") && !selection1String.equals("0")){
				System.out.println("Please enter an integer from 0 to 4 inclusive.\n1) Create new contact\t2) Edit address book\n"
					+ "3) View address book\t4) View one contact\n\n0) Quit");
				selection1String = sc.nextLine();
			}
			selection1 = 0;
			try{
				selection1 = Integer.parseInt(selection1String);
			} catch(NumberFormatException e){
				System.out.println("Error. Exiting.");
			}
			//creating contacts
/*1*/		if(selection1 == 1){
				System.out.println("Would you like to create a:\n1) Personal contact\n2) Business contact\n\n0) Return to main menu");
				String selection2String = sc.nextLine();
				while(!selection2String.equals("1") && !selection2String.equals("2") && !selection2String.equals("0")){
					System.out.println("Please choose either 1 or 2, or press 0 to return to the main menu\n1) Personal contact\n2) Business contact\n\n0) Return to main menu");
					selection2String = sc.nextLine();
				}
				int selection2 = 0;
				try{
					selection2 = Integer.parseInt(selection2String);
				} catch(NumberFormatException e){
					System.out.println("Error. Exiting.");
				}
				//goes through fields for a personal contact and assigns the responses to an array
				if(selection2 == 1){
					String[] info = new String[7];
					String indexText;
					System.out.println("Enter an index, or press enter to go to the next available index");
					indexText = sc.nextLine();
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
					//handles errors with index, as well as numbers outside of 0 and the size of the list
					int index = contacts.size();
					boolean validIndex = false;
					if(indexText.equals("")){
						validIndex = true;
					} else if(indexText.equals("") && contacts.isEmpty()){
						index = 0;
						validIndex = true;
					}
					while(!validIndex){
						try{
							index = Integer.parseInt(indexText);
							validIndex = true;
						} catch(NumberFormatException e){
							System.out.println("Index is invalid. Please enter an integer for index:");
							indexText = sc.nextLine();
						}
					}
					if(index < 0){
						index = 0;
					}
					if(index > contacts.size() && index != 0){
						System.out.println("That index is larger than the next largest unused index.\n1) Use the next index\n2) Create contact at " + index 
								+ " and create blank contacts for all indices  between " + contacts.size() + " and " + (index-1) + " inclusive");
						String largeIndexString = sc.nextLine();
						while(!largeIndexString.equals("1")&&!largeIndexString.equals("2")){
							System.out.println("Please enter a number between 1 and 2 inclusive.\n1) Use the next index\n2) Create contact at " + index 
								+ " and create blank contacts for all indices  between " + contacts.size() + " and " + (index-1) + " inclusive");
							largeIndexString = sc.nextLine();
						}
						int largeIndex = 1;
						try{
							largeIndex = Integer.parseInt(largeIndexString);
						} catch(NumberFormatException e){
							System.out.println("Error. Contact will be created at next largest unused index.");
						}
						if(largeIndex == 2){
							for(int i = contacts.size(); i < index; i++){
								contacts.add(i, new Contact("","","","","","",""));
							}
						} else {
							index = contacts.size();
						}
						
					}
					if(index < contacts.size()){
						System.out.println("A contact for " + contacts.get(index).nameToString() + " already exists at this index.\n1)Shift "
								+ contacts.get(index).nameToString() + " down\n2)Insert new contact after " + contacts.get(index).nameToString()
								+ "\n3) Overwrite " + contacts.get(index).nameToString());
						String alreadyExistsString = sc.nextLine();
						while(!alreadyExistsString.equals("1") && !alreadyExistsString.equals("2") && !alreadyExistsString.equals("3")){
							System.out.println("Please enter a number from 1 to 3 inclusive.\n1)Shift "
								+ contacts.get(index).nameToString() + " down\n2)Insert new contact after " + contacts.get(index).nameToString()
								+ "\n3) Overwrite " + contacts.get(index).nameToString());
							alreadyExistsString = sc.nextLine();
						}
						int alreadyExists = 1;
						try{
							alreadyExists = Integer.parseInt(alreadyExistsString);
						} catch(NumberFormatException e){
							System.out.println("An error occured. Contacted placed before existing contact.");
						}
						if(alreadyExists == 3){
							contacts.remove(index);
						} else if(alreadyExists == 2){
							index++;
						}
					}
					//creates the contact
					contacts.add(index, new PersonalContact(info[0], info[1], info[2], info[3], info[4], info[5], info[6]));
				//goes through the fields of a business contact
				} else if(selection2 == 2){
					String[] info = new String[9];
					String indexText;
					System.out.println("Enter an index, or press enter to go to the next available index");
					indexText = sc.nextLine();
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
					int index = contacts.size();
					boolean validIndex = false;
					if(indexText.equals("") && !contacts.isEmpty()){
						validIndex = true;
					} else if(indexText.equals("") && contacts.isEmpty()){
						index = 0;
						validIndex = true;
					}
					while(!validIndex){
						try{
							index = Integer.parseInt(indexText);
							validIndex = true;
						} catch(NumberFormatException e){
							System.out.println("Index is invalid. Please enter an integer for index:");
							indexText = sc.nextLine();
						}
					}
					if(index < 0){
						index = 0;
					}
					if(index > contacts.size()){
						System.out.println("That index is larger than the next largest unused index.\n1) Use the next index\n2) Create contact at " + index 
								+ " and create blank contacts for all indices  between " + contacts.size() + " and " + (index-1) + " inclusive");
						String largeIndexString = sc.nextLine();
						while(!largeIndexString.equals("1")&&!largeIndexString.equals("2")){
							System.out.println("Please enter a number between 1 and 2 inclusive.\n1) Use the next index\n2) Create contact at " + index 
								+ " and create blank contacts for all indices  between " + contacts.size() + " and " + (index-1) + " inclusive");
							largeIndexString = sc.nextLine();
						}
						int largeIndex = 1;
						try{
							largeIndex = Integer.parseInt(largeIndexString);
						} catch(NumberFormatException e){
							System.out.println("Error. Contact will be created at next largest unused index.");
						}
						if(largeIndex == 2){
							for(int i = contacts.size(); i < index; i++){
								contacts.add(i, new Contact("","","","","","",""));
							}
						} else {
							index = contacts.size();
						}
						
					}
					if(index < contacts.size()){
						System.out.println("A contact for " + contacts.get(index).nameToString() + " already exists at this index.\n1)Shift "
								+ contacts.get(index).nameToString() + " down\n2)Insert new contact after " + contacts.get(index).nameToString()
								+ "\n3) Overwrite " + contacts.get(index).nameToString());
						String alreadyExistsString = sc.nextLine();
						while(!alreadyExistsString.equals("1") && !alreadyExistsString.equals("2") && !alreadyExistsString.equals("3")){
							System.out.println("Please enter a number from 1 to 3 inclusive.\n1)Shift "
								+ contacts.get(index).nameToString() + " down\n2)Insert new contact after " + contacts.get(index).nameToString()
								+ "\n3) Overwrite " + contacts.get(index).nameToString());
							alreadyExistsString = sc.nextLine();
						}
						int alreadyExists = 1;
						try{
							alreadyExists = Integer.parseInt(alreadyExistsString);
						} catch(NumberFormatException e){
							System.out.println("An error occured. Contacted placed before existing contact.");
						}
						if(alreadyExists == 3){
							contacts.remove(index);
						} else if(alreadyExists == 2){
							index++;
						}
					}
					contacts.add(index, new BusinessContact(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]));
				}
				//editing the address book
/*2*/		} else if(selection1 == 2){
				if(!contacts.isEmpty()){
					boolean retry = true;
					System.out.println("What index would you like to edit?");
					String indexString = sc.nextLine();
					int index = 0;
					boolean delete = false;
					boolean notValidIndex = true;
					//handles indices out of the acceptable range
					while(notValidIndex){
						try{
							index = Integer.parseInt(indexString);
						} catch(NumberFormatException e){
							System.out.println("Please enter an integer from 0 to " + (contacts.size()-1) + " inclusive.");
							indexString = sc.nextLine();
						}
						if(index < 0 || index > contacts.size()-1){
							System.out.println("Please enter an integer from 0 to " + (contacts.size()-1) + " inclusive.");
							indexString = sc.nextLine();
						} else {
							notValidIndex = false;
						}
					}
					//loops so that you can continue making edits to one contact
					while(retry){
						//handles personal contacts
						if(contacts.get(index).getType()==0){
							System.out.println("Editing: " + contacts.get(index).nameToString() + "  Which field would you like to edit?\n1) ID\t\t2) First Name\n3) Last Name\t"
									+ "4) Address\n5) Phone Number\t6) Email\n7) Birthday\n8) Delete\n\n0) Return to main menu");
							String fieldString = sc.nextLine();
							int field = -1;
							boolean notValidInt = true;
							//makes sure the selection is correct
							while(notValidInt){
								try{
									field = Integer.parseInt(fieldString);
								} catch(NumberFormatException e){
									System.out.println("Please enter an integer from 0 to 7 inclusive.\n1) ID\t\t2) First Name\n3) Last Name\t4) Address\n"
										+ "5) Phone Number\t6) Email\n7) Birthday\n8) Delete\n\n0) Return to main menu");
									fieldString = sc.nextLine();
								}
								if(field < 0 || field > 8){
									System.out.println("Please enter an integer from 0 to 7 inclusive.\n1) ID\t\t2) First Name\n3) Last Name\t4) Address\n"
											+ "5) Phone Number\t6) Email\n7) Birthday\n8) Delete\n\n0) Return to main menu");
									fieldString = sc.nextLine();
								} else {
									notValidInt = false;
								}
							}
							//changes the field
							if(field != 0 && field != 8){
								System.out.println("That field is currently set to " + contacts.get(index).getInfo(field) + ". Enter your change, or press enter to cancel.");
								String change = sc.nextLine();
								if(!change.equals("")){
									contacts.get(index).changeInfo(field, change);
									System.out.println("The field has been updated.");
								}
								System.out.println("Would you like to make another change?\n1) Yes\n2) No");
								String again = sc.nextLine();
								again = again.toLowerCase();
								while(!again.equals("1") && !again.equals("2")){
									System.out.println("Please enter either 1 or 2.\n1) Yes\n2) No");
									again = sc.nextLine();
								}
								if(again.equals("1")){
									retry=true;
								} else {
									retry = false;
								}
							//delete
							} else if(field == 8){
								System.out.println("Are you sure you would like to delete " + contacts.get(index).nameToString() + "?\n1) Yes\n2) No");
								String again = sc.nextLine();
								again = again.toLowerCase();
								while(!again.equals("1") && !again.equals("2")){
									System.out.println("Please enter either 1 or 2.\n1) Yes\n2) No");
									again = sc.nextLine();
								}
								if(again.equals("1")){
									delete = true;
									retry = false;
								} else {
									retry = true;
								}
							} else if(field == 0) {
								retry = false;
							} 
						}
						//handles business contacts
						if(contacts.get(index).getType() == 1){
							System.out.println("Editing: " + contacts.get(index).nameToString() + "  Which field would you like to edit?\n1) ID\t\t2) First Name\n3) Last Name\t"
									+ "4) Address\n5) Phone Number\t6) Email\n7) Birthday\t8) Job Title\n9) Organization\n10) Delete\n\n0) Return to main menu");
							String fieldString = sc.nextLine();
							int field = -1;
							boolean notValidInt = true;
							while(notValidInt){
								try{
									field = Integer.parseInt(fieldString);
								} catch(NumberFormatException e){
									System.out.println("Please enter an integer from 0 to 7 inclusive.\n1) ID\t\t2) First Name\n3) Last Name\t4) Address\n"
											+ "5) Phone Number\t6) Email\n7) Birthday\t8) Job Title\n9) Organization\n10) Delete\n\n0) Return to main menu");
									sc.nextLine();
									fieldString = sc.nextLine();
								}
								if(field < 0 || field > 10){
									System.out.println("Please enter an integer from 0 to 7 inclusive.\n1) ID\t\t2) First Name\n3) Last Name\t4) Address\n"
											+ "5) Phone Number\t6) Email\n7) Birthday\t8) Job Title\n9) Organization\n10) Delete\n\n0) Return to main menu");
									sc.nextLine();
									fieldString = sc.nextLine();
								} else {
									notValidInt = false;
								}
							}
							if(field != 0 && field != 10){
								System.out.println("That field is currently set to " + contacts.get(index).getInfo(field) + ". Enter your change, or press enter to cancel.");
								String change = sc.nextLine();
								if(!change.equals("")){
									contacts.get(index).changeInfo(field, change);
									System.out.println("The field has been updated.");
								}
								System.out.println("Would you like to make another change?\n1) Yes\n2) No");
								String again = sc.nextLine();
								again = again.toLowerCase();
								while(!again.equals("1") && !again.equals("2")){
									System.out.println("Please enter either 1 or 2.\n1) Yes\n2) No");
									again = sc.nextLine();
								}
								if(again.equals("1")){
									retry=true;
								} else {
									retry = false;
								}
							} else if(field == 10){
								System.out.println("Are you sure you would like to delete " + contacts.get(index).nameToString() + "?\n1) Yes\n2) No");
								String again = sc.nextLine();
								again = again.toLowerCase();
								while(!again.equals("1") && !again.equals("2")){
									System.out.println("Please enter either 1 or 2.\n1) Yes\n2) No");
									again = sc.nextLine();
								}
								if(again.equals("1")){
									delete = true;
									retry = false;
								} else {
									retry = true;
								}
							} else if(field == 0) {
								retry = false;
							} 
						//handles contacts created automatically by using an index above the previous size of the array when creating a new contact
						} else if(contacts.get(index).getType() == -1){
							System.out.println("This contact was created automatically. Please complete the following to initiate it.");
							
							//reruns the create dialogue without all of the index stuff
							System.out.println("Would you like to create a:\n1) Personal contact\n2) Business contact\n3) Delete contact"
									+ "\n\nPress 0 to return to the main menu");
							String selection2String = sc.nextLine();
							while(!selection2String.equals("1") && !selection2String.equals("2") && !selection2String.equals("0") && !selection2String.equals("3")){
								System.out.println("Please select a number between 0 and 3 inclusive.\n1) Personal contact\n2) Business contact"
										+ "\n3) Delete contact\n\nPress 0 to return to the main menu");
								selection2String = sc.nextLine();
							}
							int selection2 = 0;
							try{
								selection2 = Integer.parseInt(selection2String);
							} catch(NumberFormatException e){
								System.out.println("Error. Exiting.");
							}
							if(selection2 == 1){
								String[] info = new String[7];
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
								contacts.set(index, new PersonalContact(info[0], info[1], info[2], info[3], info[4], info[5], info[6]));
							} else if(selection2 == 2){
								String[] info = new String[9];
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
								contacts.set(index, new BusinessContact(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]));
							//handles deletion of the blank contact
							} else if(selection2 == 3){
								System.out.println("Are you sure you would like to delete blank contact at " + index + "?\n1) Yes\n2) No");
								String again = sc.nextLine();
								again = again.toLowerCase();
								while(!again.equals("1") && !again.equals("2")){
									System.out.println("Please enter either 1 or 2.\n1) Yes\n2) No");
									again = sc.nextLine();
								}
								if(again.equals("1")){
									delete = true;
									retry = false;
								} else {
									retry = true;
								}
							}
							retry = false;
						}
					}
					if(delete){
						contacts.remove(index);
					}
				} else {
					System.out.println("No contacts entered.\n");
				}
			//prints out the address book
/*3*/		} else if(selection1 == 3){
				System.out.println("Would you like to view:\n1) All contacts\n2) Personal contacts\n3) Business contacts\n\n0) Return to main menu");
				String contactTypeString = sc.nextLine();
				while(!contactTypeString.equals("1") && !contactTypeString.equals("2") && !contactTypeString.equals("3") && !contactTypeString.equals("0")){
					System.out.println("Please enter an integer from 0 to 3 inclusive.\n1) All contacts\n2) Personal contacts\n3) Business contacts\n\n0) Return to main menu");
					contactTypeString = sc.nextLine();
				}
				int contactType = 1;
				try{
					contactType = Integer.parseInt(contactTypeString);
				} catch(NumberFormatException e){
					System.out.println("Error. Displaying all contacts.");
				}
				System.out.println("\n");
				//displays all contacts
				if(contactType == 1){
					for(int i = 0; i < contacts.size(); i++){
						if(contacts.get(i).getType() == 0){
							System.out.print(i + "\tPersonal Contact");
						} else if(contacts.get(i).getType() == 1){
							System.out.print(i + "\tBusiness Contact");
						} else {
							System.out.print(i + "\t     Contact    ");
						}
						System.out.println("\t" + contacts.get(i).toString());
					}
					System.out.println("\n\n0) Return to main menu");
					String quit = sc.nextLine();
					while(!quit.equals("0")){
						quit = sc.nextLine();
					}
				//displays personal contacts
				} else if(contactType == 2){
					for(int i = 0; i < contacts.size(); i++){
						if(contacts.get(i).getType() == 0){
							System.out.println(i + "\t" + contacts.get(i).toString());
						}
					}
					System.out.println("\n\n0) Return to main menu");
					String quit = sc.nextLine();
					while(!quit.equals("0")){
						quit = sc.nextLine();
					}
				//displays business contacts
				} else if(contactType == 3){
					for(int i = 0; i < contacts.size(); i++){
						if(contacts.get(i).getType() == 1){
							System.out.println(i + "\t" + contacts.get(i).toString());
						}
					}
					System.out.println("\n\n0) Return to main menu");
					String quit = sc.nextLine();
					while(!quit.equals("0")){
						quit = sc.nextLine();
					}
				}
			//viewing one contact
/*4*/		} else if(selection1 == 4){
				if(!contacts.isEmpty()){
					System.out.println("Enter the index of the contact you would like to view");
					String indexString = sc.nextLine();
					int index = -1;
					boolean notValidInt = true;
					while(notValidInt){
						try{
							index = Integer.parseInt(indexString);
						} catch(NumberFormatException e){
							System.out.println("Please enter an integer from 0 to " + (contacts.size()-1) +" inclusive.");
							indexString= sc.nextLine();
						}
						if(index < 0 || index > contacts.size()-1){
							System.out.println("Please enter an integer from 0 to " + (contacts.size()-1) +" inclusive.");
							indexString = sc.nextLine();
						} else {
							notValidInt = false;
						}
					}
					System.out.println("\n");
					if(contacts.get(index).getType() == 0){
						System.out.print(index + "\tPersonal Contact");
					} else if(contacts.get(index).getType() == 1){
						System.out.print(index + "\tBusiness Contact");
					} else {
						System.out.print(index + "\t     Contact    ");
					}
					System.out.println("\t" + contacts.get(index).toString() + "\n\n0) Return to main menu");
					String quit =sc.nextLine();
					while(!quit.equals("0")){
						quit = sc.nextLine();
					}
				} else {
					System.out.println("No contacts entered.\n");
				}
			}
		}
		sc.close();
	}

}
