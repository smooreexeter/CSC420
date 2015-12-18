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
			default: break;
		}
		return ret;
	}
	
	public int getType(){
		return -1;
	}
	
	public String toString(){
		return id + ": " + lName + ", " + fName + "\t\t\t" + address + "\t" + email + "\t" + pNum + "\t" + bDay;
	}
	
	public String nameToString(){
		return lName + ", " + fName;
	}
	
}
