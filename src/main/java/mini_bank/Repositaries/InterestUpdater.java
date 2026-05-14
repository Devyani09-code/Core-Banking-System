package mini_bank.Repositaries;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import mini_bank.Components.Fixed_Deposit_Account;
import mini_bank.Components.Savings_Account;

@Component
public class InterestUpdater {

	    @Autowired
	    private Savings_Account_Repositary sr;
 
	    @Autowired
	    private Fixed_Deposit_Repositary fdr;

	    @Scheduled(fixedRate = 30L * 24 * 60 * 60 * 1000)
	    public void updateInterest() {
	        
	        for(Savings_Account acc : sr.findAll()) {
	            acc.setBalance(acc.getBalance() + (int)(acc.getBalance() * 0.07));
	            sr.save(acc);
	        }

	    }
	    
	    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
	    public void updateFD() {
	        for(Fixed_Deposit_Account fd : fdr.findAll()) {
	            int days = (int) ChronoUnit.DAYS.between(fd.getStart_date(), LocalDate.now());
	            fd.setBalance(fd.getBalance() + (fd.getBalance() * 8 / 100 / 365 * days));
	            fdr.save(fd);
	        }
	    }
	}

