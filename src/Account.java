import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Account {
	String customerID;
	String customerName;
	int balance;
	int prevTransaction;
	public Account(String cname, String cid) {
		customerName = cname;
		customerID=cid;
	}
    
     
	 void deposit(int amount) {
		if (amount != 0 && amount>0) {
			balance = balance + amount;
			prevTransaction = amount;
		}
    }  
	 
	 void withdraw(int amount) {
			if (amount != 0 && amount>0) {
				balance = balance - amount;
				prevTransaction = -amount;
			}
	}
	
	 void getPrevTransaction() {
		 if (prevTransaction>0) {
			 System.out.println("Deposited "+prevTransaction);
		 }
		 else if(prevTransaction<0) {
			 System.out.println("Withdrawn: "+Math.abs(prevTransaction));
		 }
		 else {
			 System.out.println("no Transaction occured!");
		 }
	 }
	 
	 void date() {
		 var today = new Date();
		 SimpleDateFormat SDF = new SimpleDateFormat ("E yyyy.MM.dd  'at' hh:mm:ss a zzz");
		 System.out.println("Current Date: " +  SDF.format(today));
	 }
	 
	 void showMenu() {
		 char option = '\0';
		 Scanner scanner= new Scanner(System.in);
		 
		 System.out.println("Welcome "+customerName+"!");
		 System.out.println("Your ID is: "+customerID+"!");
		 System.out.println();
		 System.out.println("What would you like to do?");
		 System.out.println();
		 System.out.println("A. Check Your Balance");
		 System.out.println("B. Make A Deposit");
		 System.out.println("C. Make A Withdraw");
		 System.out.println("D. View Previous Transaction");
		 System.out.println("E. View The Date of Today");
		 System.out.println("F. Exit");
		 
		 do {
			 System.out.println();
			 System.out.println("Please Enter An Option: ");
			 char option1= scanner.next().charAt(0);
			 option = Character.toUpperCase(option1);
			 switch (option) {
			 case 'A':
				 System.out.println("=================");
				 System.out.println("Balance= "+balance+"$");
				 System.out.println("=================");
				 break;
			 case 'B':
				 System.out.println("Enter An Amount To Deposit: ");
				 int amount= scanner.nextInt();
				 deposit(amount);
				 break;
			 case 'C':
				 System.out.println("Enter An Amount To Withdraw: ");
				 int amount2= scanner.nextInt();
				 withdraw(amount2);
				 break;
			 case 'D':
				 System.out.println("=================");
				 getPrevTransaction();
				 System.out.println("=================");
				 break;
			 case 'E':
				 System.out.println("=================");
				 date();
				 System.out.println("=================");
				 break;
			 case 'F':
				 System.out.println("=================");
				 break;
				 default:
					 System.out.println("Error: Invalid Option. Please Enter A,B,C,D,E or F");
					 break;
			 }
			 
		 }while(option != 'F');
		 System.out.println("Thank You For Using Our ATM!");
	 }
}
