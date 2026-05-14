package mini_bank.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mini_bank.Components.Fixed_Deposit_Account;
import mini_bank.Repositaries.Fixed_Deposit_Repositary;

@Service
public class Fixed_Deposit_Services {

	private final Fixed_Deposit_Repositary fdr;

	public Fixed_Deposit_Services(Fixed_Deposit_Repositary fdr) {
		this.fdr = fdr;
	}
	
	//create account
	public Fixed_Deposit_Account create(Fixed_Deposit_Account fda) {
		return fdr.save(fda);
	}
	
//create dates 
	public Fixed_Deposit_Account setDate(Fixed_Deposit_Account fda) {
		fda.setStart_date(LocalDate.now());
		fda.setEnd_date(fda.getStart_date().plusMonths(fda.getMonths()));
		return fda;
	}
	
	//delete account and claim value
	public int closeFD(Long account_number) {
	    return fdr.findById(account_number).map(fda -> {
	        int amount = fda.getBalance();
	        fdr.deleteById(account_number);
	        return amount;
	    }).orElse(null);
	}
	
	//fetch the data
	public Fixed_Deposit_Account FDAccount(String name) {
		return fdr.findByNameFD(name);
	}
	
	
}
