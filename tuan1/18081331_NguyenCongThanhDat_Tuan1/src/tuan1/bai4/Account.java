package tuan1.bai4;

public class Account {
	private String name;
	private double balance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(String name) {
		super();
		this.name = name;
		this.balance = 50000;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", balance=" + balance + "]";
	}
	
	public boolean deposit(double amount) {
		if (amount < 0)
			return false;
		balance += amount;
		return true;
	}
	public synchronized double withdraw(double amount) {
		if(amount < 0) 
			return 0;
		balance -= amount;
		return amount;
	}
}
