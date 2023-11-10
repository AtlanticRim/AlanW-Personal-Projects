import java.util.*;
//Code created by J. Alan Wallace, 1/24/2022, CS226

public class TestAccount {
	public static void main(String[] args) {
		Account myAccount = new Account(1122, 20000);//Creates an account
		System.out.println("Beginning Account Details: ");
		System.out.println(myAccount.toString());
		myAccount.withdraw(100);
		myAccount.deposit(500);
		System.out.println("Account details after a withdrawal of $100 and a deposit of $500:");
		System.out.println(myAccount.toString());

	}//End main
}//End TestAccount

class Account{
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();;
	
	Account(){
		
	}//End no-arg constructor
	
	Account(int inputId, double inputBalance){
		id = inputId;
		balance = inputBalance;
		annualInterestRate = 0.045;//Default AIR is 4.5%
	}//End constructor

	public void setId(int newId) {
		id = newId;
	}//End setId
	
	public int getId() {
		return id;
	}//End getId

	public void setBalance(double newBalance) {
		balance = newBalance;
	}//End setBalance
	
	public double getBalance() {
		return balance;
	}//End getBalance
	
	public void setAnnualInterestRate(double newAIR) {
		annualInterestRate = newAIR;
	}//End setAIR
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}//End getAIR
	
	public Date getDateCreated() {
		return dateCreated;
	}//End getDateCreated
	
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}//End getMIR
	
	public double getMonthlyInterest() {
		return balance * getMonthlyInterestRate();
	}//End getMonthlyInterest
	
	public void withdraw(double withdrawal) {
		double previousBalance = getBalance();
		double newBalance = previousBalance - withdrawal;
		setBalance(newBalance);
	}//End withdraw
	
	public void deposit(double depositing) {
		double previousBalance = getBalance();
		double newBalance = previousBalance + depositing;
		setBalance(newBalance);
	}//End deposit
	
	public String toString() {
		return "ID: " + getId() + " Balance: " + getBalance() + " Annual Interest Rate: " + getAnnualInterestRate() + " Monthly Interest Rate: " + getMonthlyInterestRate() + " Monthly Interest: " + getMonthlyInterest() + " Date Created: " + dateCreated;
	}//End toString
}
