
public class AnimalRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Animal();
		Dog d = new Dog();
		Cat c = new Cat();
		Bird b = new Bird();
		Animal[] ar = new Animal[4];
		
		ar[3] = d;
		ar[1] = c;
		ar[2] = b;
		ar[0] = a;
		
		System.out.println("");
		
		for(int i = 0; i < 4; i++){
			ar[i].Sleep();
		}
		
		System.out.println("");
		
		for(int i = 0; i < 4; i ++){
			ar[i].Eat();
		}
		
		Animal m = new Cat();
		m.Eat();
	}
	
	

}
