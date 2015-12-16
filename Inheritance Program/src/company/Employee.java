package company;

public class Employee extends Staff{
	int p;
	public Employee(String name, String address, String phone, int pay){
		super(name, address, phone);
		p=pay;
	}
	public int hourly(){
		return p;
	}
	
}
