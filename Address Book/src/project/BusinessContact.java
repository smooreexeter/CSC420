package project;

public class BusinessContact extends Contact{

	String jTitle, org;
	
	public BusinessContact(String id1, String fName1, String lName1, String address1, String pNum1, String email1, String bDay1, String jTitle1, String org1){
		super(id1, fName1, lName1, address1, pNum1, email1, bDay1);
		jTitle = jTitle1;
		org = org1;
	}
	
	public void changeInfo(int info, String change){
		switch(info){
			case 1: id = change;
					break;
			case 2: fName = change;
					break;
			case 3: lName = change;
					break;
			case 4: address = change;
					break;
			case 5: pNum = change;
					break;
			case 6: email = change;
					break;
			case 7: bDay = change;
					break;
			case 8: jTitle = change;
					break;
			case 9: org = change;
					break;
			default: break;
		}
	}
	
	public int getType(){
		return 1;
	}
}
