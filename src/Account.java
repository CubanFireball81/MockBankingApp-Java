import java.util.Scanner;

public class Account {
	// Class Variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	// Class Constructor
	Account(String cname, String cid) {
		customerName = cname;
		customerID = cid;
	}
	
	// Function to Deposit Money
	void deposit(int amount) {
		if (amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	// Function to Withdraw Money
	void withdraw(int amount) {
		if (amount != 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}
	
	//Function to Show Previous Transaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else {
			System.out.println("There are no previous transactions.");
		}
	}
	
	//Function to calculate interest based on funds in account and user supplied number of years
	void calculateInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is " + (100 * interestRate) + "%");
		System.out.println("After " + years + " years, your balance will be: " + newBalance);
	}
	
	// Function to show the Main Menu
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("B. Check your balance");
		System.out.println("D. Make a deposit");
		System.out.println("W. Make a withdrawl");
		System.out.println("P. View previous transaction");
		System.out.println("I. Calculate interest");
		System.out.println("X. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			// Case 'B' allows the user to check their account balance
			case 'B':
				System.out.println("================");
				System.out.println("Balance = $" + balance);
				System.out.println("================");
				System.out.println();
				break;
			// Case 'D' allows the user to deposit money into their account
			case 'D':
				System.out.println("Enter an amount to deposit: ");
				int depositAmount = scanner.nextInt();
				deposit(depositAmount);
				System.out.println();
				break;
			// Case 'W' allows the user to withdraw money from their account
			case 'W':
				System.out.println("Enter an amount to withdraw: ");
				int withdrawAmount = scanner.nextInt();
				withdraw(withdrawAmount);
				System.out.println();
				break;
			// Case 'P' allows the user to view their previous transactions
			case 'P':
				System.out.println("================");
				getPreviousTransaction();
				System.out.println("================");
				System.out.println();
				break;
			// Case 'I' calculates the accrued interest on the funds in the account for the number of years the user specifies
			case 'I':
				System.out.println("Enter how many years to calculate the accrued interest: ");
				int interestYears = scanner.nextInt();
				calculateInterest(interestYears);
				break;
			// Case 'X' exits the user from their account
			case 'X':
				System.out.println("========Logging you out========");
				break;
			// The default case let's the user know they have entered an invalid option
			default:
				System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services.");
				break;
			}
		} while (option != 'X');
		System.out.println("Thank you for banking with us today " + customerName + "!");
	}
}