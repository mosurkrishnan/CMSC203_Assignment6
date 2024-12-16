
public class Customer {
	int age;
	String name;
	
	public Customer(String name, int age) {
		this.age = age;
		this.name = name;
	}
	public Customer(Customer c) { // copy constructor
		this.age = c.age;
		this.name = c.name;
		
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	// String representation of the customer includes the name and age of the customer.
	public String toString() {
		return "Name: " + name + " Age: " + age;
		
	}

	

}
