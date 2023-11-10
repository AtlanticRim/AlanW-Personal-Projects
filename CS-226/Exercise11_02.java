import java.util.Date;

public class Exercise11_02 {
	//Code created by Jeremy Alan Wallace 2/18/2022 CS226
	public static void main(String[] args) {

		Date evaHired = new Date(1990, 1, 2);
		Date frankHired = new Date(2000, 2, 3);
		Date shaneHired = new Date(2010, 3, 4);
		
		Person peter = new Person("Peter", "211 Alumni Drive", "1234567890", "peter@gmail.com");
		Student susan = new Student("Susan", "212 Alumni Drive", "2345678901", "susan@gmail.com", "Freshman");
		Employee eva = new Employee("Eva", "213 Alumni Drivve", "3456789012", "eva@gmail.com", "FH227", 80000, evaHired);
		Faculty frank = new Faculty("Frank", "214 Alumni Drive", "4567890123", "frank@gmail.com", "FH228", 900000, frankHired, "MWF1-3", "Professor");
		Staff shane = new Staff("Shane", "215 Alumni Drive", "5678901234", "shane@gmail.com", "FH229", 50000, shaneHired, "Assistant Professor");
		
		System.out.println(peter.toString());
		System.out.println(susan.toString());
		System.out.println(eva.toString());
		System.out.println(frank.toString());
		System.out.println(shane.toString());
		
	}//End main
}//End Exercise11_02

class Person{
	String name;
	String address;
	String phoneNo;
	String email;

	Person(){
		
	}//End no-arg constructor
	
	Person(String name, String address, String phoneNo, String email){
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
	}//End constructor
	
	public String toString(){
		return "Person: " + name;
	}//End toString
	
}//End Person

class Student extends Person{
	final String STATUS;//Needs to be constant
	
	Student(){
		this.STATUS = "";
		
	}//End no-arg constructor
	
	Student(String name, String address, String phoneNo, String email, String status){
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.STATUS = status;
	}//End constructor
	
	public String toString(){
		return "Student: " + name;
	}//End toString
	
}//End Student

class Employee extends Person{
	String office;
	double salary;
	Date hired = new Date();
	
	Employee(){
		
	}//End no-arg constructor
	
	Employee(String name, String address, String phoneNo, String email, String office, double salary, Date hired){
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.office = office;
		this.salary = salary;
		this.hired = hired;
	}//End constructor
	
	public String toString(){
		return "Employee: " + name;
	}//End toString
	
}//End Employee

class Faculty extends Employee{
	String officeHours;
	String rank;
	
	Faculty(){
		
	}//End no-arg constructor
	
	Faculty(String name, String address, String phoneNo, String email, String office, double salary, Date hired, String officeHours, String rank){
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.office = office;
		this.salary = salary;
		this.hired = hired;
		this.officeHours = officeHours;
		this.rank = rank;
	}//End constructor
	
	public String toString(){
		return "Faculty: " + name;
	}//End toString
	
}//End Faculty

class Staff extends Employee{
	String title;
	
	Staff(){
		
	}//End no-arg constructor
	
	Staff(String name, String address, String phoneNo, String email, String office, double salary, Date hired, String title){
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.office = office;
		this.salary = salary;
		this.hired = hired;
		this.title = title;
	}//End constructor
	
	public String toString(){
		return "Staff: " + name;
	}//End toString
	
}//End Staff

/*Sample Output
Person: Peter
Student: Susan
Employee: Eva
Faculty: Frank
Staff: Shane
 */