package company;

public class Volunteer extends Staff{

	public Volunteer(String name, String address, String phone){
		super(name, address, phone);
	}
	public int hourly(){
		return super.hourly();
	}
}
