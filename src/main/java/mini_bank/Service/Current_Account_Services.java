package mini_bank.Service;

import mini_bank.Components.Current_Account;
import mini_bank.Components.Savings_Account;
import mini_bank.Repositaries.Current_Account_Repositary;
import org.springframework.stereotype.Service;

@Service
public class Current_Account_Services {

private final Current_Account_Repositary car;

public Current_Account_Services(Current_Account_Repositary car) {
	this.car = car;
}

//create account
public Current_Account CAcreate_acc(Current_Account ca) {
	return car.save(ca);
}

//withdraw
public int CAwithdraw(Long account_number, Integer sum) {
	return car.findById(account_number).map(sa -> {
		sa.setBalance(sa.withdraw(sa.getSum(), sa.getBalance()));
		car.save(sa);
		return sa.getBalance();
	}).orElse(null);
}

//deposit
public int CAdeposit(Long account_number, Integer sum) {
	return car.findById(account_number).map(sa -> {
		sa.setBalance(sa.deposit(sum, sa.getBalance()));
		car.save(sa);
		return sa.getBalance();
	}).orElse(null);
}

//terminate account
public void CAterminate(Long account_number) {
	car.deleteById(account_number);
}

//fetch the data
public Current_Account CAccount(String name) {
	return car.findByName(name);
}

}