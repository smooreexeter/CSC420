package project;

public class BusinessContact extends Contact{

	String jTitle, org;
	
	public BusinessContact(String id1, String fName1, String lName1, String address1, String pNum1, String email1, String bDay1, String jTitle1, String org1){
		super(id1, fName1, lName1, address1, pNum1, email1, bDay1);
		jTitle = jTitle1;
		org = org1;
	}
}
