package mini_bank.Service;

import mini_bank.Components.Savings_Account;
import mini_bank.Repositaries.Savings_Account_Repositary;
import org.springframework.stereotype.Service;

@Service
public class Saving_Account_Services {
private final Savings_Account_Repositary sar;


public Saving_Account_Services(Savings_Account_Repositary sar) {
	this.sar=sar;
}

//create account
public Savings_Account SAcreate_acc(Savings_Account sa) {
  return sar.save(sa);	
}

//withdraw
public int SAwithdraw(Long account_number,Integer sum) {
	return sar.findById(account_number).map(sa->{
		sa.setBalance(sa.withdraw(sa.getSum(),sa.getBalance()));
		sar.save(sa);
		return sa.getBalance();
		}).orElse(null);
}

//deposit
public int SAdeposit(Long account_number,Integer sum) {
	return sar.findById(account_number).map(sa->{
		sa.setBalance(sa.deposit(sum,sa.getBalance()));
		sar.save(sa);
		return sa.getBalance();
	}).orElse(null);
}

//terminate account
public void SAterminate(Long account_number) {
	sar.deleteById(account_number);
}

//fetch the data
public Savings_Account SAccount(String name) {
	return sar.findByNameSA(name);
}

}
