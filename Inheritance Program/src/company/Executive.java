package company;

public class Executive extends Staff{
	
	public Executive(String name, String address, String phone){
		super(name, address, phone);
	}
	public int hourly(){
		return 100;
	}
	
}
