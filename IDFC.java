package bankingidfc;
class UnsufficientBalance extends RuntimeException {
	public UnsufficientBalance() {
		super("You dont have sufficent balance !!! aorry for inconvinience ");
	}
}

interface Bank {
	String nameOfBank = "IDFC First Bank";
}

class BankingSystem implements Bank {
	static void greetings() {
		System.out.println("____");
		System.out.println("Welcome to " + nameOfBank);
		System.out.println("____");
	}

	private static double banktoalbalance = 100000;

	public static double getBanktoalbalance() {
		return banktoalbalance;
	}

	private double balance = 10000;
	private static int count = 1;
	private int accountId;
	private String name;
	private double amount;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId() {
		this.accountId = count;
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public BankingSystem() {
		this.setAccountId();
		banktoalbalance += balance;
	}

	public BankingSystem(String name, double amount) {
		this.setAccountId();
		this.name = name;
		this.amount = amount;
		banktoalbalance += balance;
	}

	public void depositAmount(double amount) {
		balance += amount;
		this.amount += amount;
		banktoalbalance -= amount;
		System.out.println("Depisite Successful of " + amount);
	}

	public void withdrawAmount(double amount) {
		balance -= amount;
		if (balance < 0) {
			throw new UnsufficientBalance();
		}
		this.amount -= amount;
		banktoalbalance -= amount;
		System.out.println("withdrawal Successful of " + amount);
	}

	public void transferAmount(double amount) {
		banktoalbalance += amount;
	}

	public void viewBalance() {
		System.out.println("accountId = " + this.accountId);
		System.out.println("accountHolderName = " + this.name);
		System.out.println("currentBalance = " + this.amount);
	}
}

class Users extends BankingSystem {
	void displayBankBalance() {
		System.out.println("total amount in bank : " + BankingSystem.getBanktoalbalance());
	}

	public Users() {
		super();
	}

	public Users(String name, int amount) {
		super(name, amount);
		BankingSystem.greetings();
	}
}

public class IDFC {
	public static void main(String[] args) {
		try {
			Users us1 = new Users("priyam", 1000);
			us1.withdrawAmount(100);
			us1.viewBalance();
			us1.displayBankBalance();
			Users us2 = new Users("anand", 1000);
			us2.depositAmount(100);
			us2.viewBalance();
			us2.displayBankBalance();
			Users us3 = new Users("user3", 1000);
			us3.withdrawAmount(1012320);
			us3.viewBalance();
			us3.displayBankBalance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Successfully Terminated ");
	}
}

