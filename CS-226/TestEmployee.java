
public class TestEmployee {
	//Code created by J. Alan Wallace 2/4/2021 CS-226
	public static void main(String[] args) {
		EmpDate dob = new EmpDate("Jan", "1", "1980");
		EmpDate hire = new EmpDate("Dec", "31", "2000");
		EmployeeNew emp1 = new EmployeeNew("John", "Doe", dob, hire);
		System.out.println(emp1.toString());
	}//End main
}//End TestEmployeeNew

class EmployeeNew{
	private String firstName;
	private String lastName;
	private EmpDate birthDate;
	private EmpDate hireDate;
	
	EmployeeNew(){
		
	}//End no-arg constructor
	
	EmployeeNew(String firstName, String lastName, EmpDate birthDate, EmpDate hireDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
	}//End constructor
	
	public String toString() {
		return firstName + " " + lastName + " " + "DOB: " + birthDate.toString() + " Hired on: " + hireDate.toString();
	}//End toString
	
}//End EmployeeNew

class EmpDate{
	private String month;
	private String day;
	private String year;
	
	EmpDate(){
		
	}//End no-arg constructor
	
	EmpDate(String month, String day, String year){
		this.month = month;
		this.day = day;
		this.year = year;
	}//End constructor
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}//End toString
	
}//End EmpDate