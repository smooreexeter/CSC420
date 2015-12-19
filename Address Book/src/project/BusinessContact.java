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
	
	public String getInfo(int info){
		String ret = "";
		switch(info){
			case 1: ret = id;
					break;
			case 2: ret = fName;
					break;
			case 3: ret = lName;
					break;
			case 4: ret = address;
					break;
			case 5: ret = pNum;
					break;
			case 6: ret = email;
					break;
			case 7: ret = bDay;
					break;
			case 8: ret = jTitle;
					break;
			case 9: ret = org;
					break;
			default: break;
		}
		return ret;
	}
	
	public String toString(){
		//doesn't add info if it doesn't exist for that object
		String ret = "";
		if(!lName.isEmpty()){
			ret += lName;
		}
		if(!fName.isEmpty()){
			ret += ", " + fName;
		}
		if(!id.isEmpty()){
			ret += "\tID: " + id;
		}
		if(!address.isEmpty()){
			ret += "\tAddress: " + address;
		}
		if(!email.isEmpty()){
			ret += "\tEmail: " + email;
		}
		if(!pNum.isEmpty()){
			ret += "\tPhone Number: " + pNum;
		}
		if(!bDay.isEmpty()){
			ret += "\tBirthday: " + bDay;
		}
		if(!jTitle.isEmpty()){
			ret += "\tJob Title: " + jTitle;
		}
		if(!org.isEmpty()){
			ret += "\tCompany: " + org;
		}
		return ret;
	}
	
	public int getType(){
		return 1;
	}
}
