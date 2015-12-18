package project;

public class PersonalContact extends Contact{
	
	public PersonalContact(String id1, String fName1, String lName1, String address1, String pNum1, String email1, String bDay1){
		super(id1, fName1, lName1, address1, pNum1, email1, bDay1);
	}
	
	public int getType(){
		return 0;
	}
	
	
}
