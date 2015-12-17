package project;

public class Contact {

	String id, fName, lName, address, pNum, email, bDay;
	
	public Contact(String id1, String fName1, String lName1, String address1, String pNum1, String email1, String bDay1){
		id = id1;
		fName = fName1;
		lName = lName1;
		address = address1;
		pNum = pNum1;
		email = email1;
		bDay = bDay1;
	}
	
	public String toString(){
		return lName + ", " + fName;
	}
	
}
