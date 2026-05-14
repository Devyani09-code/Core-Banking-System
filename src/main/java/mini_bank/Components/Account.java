package mini_bank.Components;



public class Account {

	public int withdraw(int sum,int balance) {
		if(balance<sum) {
			return -1;
		}
		else {
			int amount=balance-sum;
			return amount;
		}
	}
	
	public int deposit(int sum,int balance) {
		    balance=balance+sum;
			return balance;
	}
}
