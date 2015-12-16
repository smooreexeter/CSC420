package company;

public class Company {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Staff[] staff = new Staff[5];
		staff[0] = new Executive("John","1 Main St.", "0000000000");
		staff[1] = new Employee("Jim", "2 Main St.", "0000000001", 50);
		staff[2] = new Employee("Jeff", "3 Main St.", "0000000002", 45);
		staff[3] = new Volunteer("Bob", "4 Main St.", "0000000003");
		staff[4] = new Volunteer("Bill", "5 Main St.", "0000000004");
		
		System.out.println(staff[2].n + "'s pay is $" + staff[2].hourly() + " per hour.");
	}

}
