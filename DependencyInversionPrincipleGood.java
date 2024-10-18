//Dependency-Inversion Principle
class Bank {
	public void processTransaction(BasicAccount from, BasicAccount to, int amount) {
		if (from.getBalance() >= amount) {
			from.withdraw(amount);
			to.deposit(amount);
		}
	}
}

interface BasicAccount {
	int getBalance();
	void deposit(int amount);
	void withdraw(int amount);
}

class CheckingAccount implements BasicAccount {
	private int balance = 0;
	private double interest_rate = 0.003;

	public int getBalance() {
		return balance;
	}

	public void withdraw (int amount) {
		if (balance >= amount)
			balance -= amount;
		else
			throw new UnsupportedOperationException("Insufficient Funds!");
	}

	public void deposit(int amount) {
		balance += amount;
	}
}

public class DependencyInversionPrincipleGood {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BasicAccount checking = new CheckingAccount();
        checking.deposit(100);
        BasicAccount saving = new SavingsAccount();

        System.out.println("Before transaction:");
        System.out.println("Checking account balance is $" + checking.getBalance());
        System.out.println("Saving account balance is $" + saving.getBalance());

        bank.processTransaction(checking, saving, 50);

        System.out.println("After transaction:");
        System.out.println("Checking account balance is $" + checking.getBalance());
        System.out.println("Saving account balance is $" + saving.getBalance());
    }
}

class SavingsAccount implements BasicAccount {
	private int balance = 0;
	private double interest_rate = 0.0125;
	private int withdrawals_this_month = 0;
	private final int MAX_WITHDRAWALS_PER_MONTH = 6;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		if (withdrawals_this_month >= MAX_WITHDRAWALS_PER_MONTH)
			throw new UnsupportedOperationException("Too many withdrawals this month! (US Regulation D)");
		if (balance >= amount) {
			balance -= amount;
			withdrawals_this_month += 1;
		} else
			throw new UnsupportedOperationException("Insufficient Funds!");
	}

	public void deposit(int amount) {
		balance += amount;
	}
}


