package mini_bank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import mini_bank.Components.*;
import mini_bank.Service.*;


@RestController
public class Operation_Controller {
	
	private final User_Service us;
	private final Saving_Account_Services sas;
	private final Fixed_Deposit_Services fds;
	private final Current_Account_Services cas;
	@Autowired
	public Operation_Controller(User_Service us,Saving_Account_Services sas,Fixed_Deposit_Services fds,
			Current_Account_Services cas) {
		this.us=us;
		this.sas=sas;
		this.fds=fds;
		this.cas=cas;	}
	
	@PostMapping("/signup")
	public User SignUp(@RequestBody User user,HttpSession session) {
		 User savedUser = us.create_user(user);
		    session.setAttribute("customer_id", savedUser.getCustomer_id());
		    session.setAttribute("name", savedUser.getName());
		    return savedUser;
	}
	
	@DeleteMapping("/logout")
	public void Logout(@RequestBody Long customer_id,HttpSession session) {
		us.delete_user(customer_id);
		session.invalidate();
	}
	
	@PostMapping("/login")
	public User Login(@RequestBody User newuser, HttpSession session) {
	    User user = us.login(newuser);
	    if(user != null) {
	        session.setAttribute("customer_id", user.getCustomer_id());
	        session.setAttribute("name", user.getName());
	        return user;
	    }
	    return null;
	}
	
	@GetMapping("/profile")
	public User getProfile(HttpSession session) {
		User user;
	    Long acc = (Long) session.getAttribute("customer_id");
	    if(acc == null) return null;
	    return us.search(acc).orElse(null);
	}
	
	//crate savings
	@PostMapping("/createSavings_Acc")
	public  Savings_Account createSA(@RequestBody Savings_Account sa) {
		return sas.SAcreate_acc(sa);
	}
	
	//withdraw from savings
	@PostMapping("/saving_acc_withdraw")
	public void withdraw_sa(@RequestParam Long account_number, @RequestBody Integer sum) {
	    sas.SAwithdraw(account_number, sum);
	}
	
	//deposit from savings
	@PostMapping("/saving_acc_deposit")
	public void deposit_sa(@RequestParam Long account_number, @RequestBody Integer sum) {
	    sas.SAdeposit(account_number, sum);
	}
		
   //delete account from savings
		@DeleteMapping("/saving_acc_delete")
		public void delete_sa(@RequestBody Long account_number) {
			sas.SAterminate(account_number);
		}
		
	//create fd
		@PostMapping("/fixed_deposit_creation")
		public Fixed_Deposit_Account create_fd(@RequestBody Fixed_Deposit_Account fda){
			return fds.create(fda);
		}
		
	//delete fd
	    @DeleteMapping("/fixed_deposit_termination")
	    public int delet_fd(@RequestParam Long account_number) {
	    	return fds.closeFD(account_number);
	    }
	    
	    
	  //crate savings
		@PostMapping("/createCurrent_Acc")
		public  Current_Account createCA(@RequestBody Current_Account ca) {
			return cas.CAcreate_acc(ca);
		}
		
		//withdraw from current
		@PostMapping("/current_acc_withdraw")
		public void withdraw_ca(@RequestBody Integer sum,@RequestParam Long account_number) {
			cas.CAwithdraw(account_number, sum);
		}
		
		//deposit from current
			@PostMapping("/current_acc_deposit")
			public void deposit_ca(@RequestBody Integer sum,@RequestParam Long account_number) {
				cas.CAdeposit(account_number, sum);
			}
			
	   //delete account from current
			@DeleteMapping("/current_acc_delete")
			public void delete_ca(@RequestParam Long account_number) {
		        cas.CAterminate(account_number);
			}
			
		//fetching current account
			@GetMapping("/search_ca_holder")
			public Current_Account search_ca(HttpSession session) {
			    String s1 = (String) session.getAttribute("name");
			    return cas.CAccount(s1);  // returns null if not found, object if found
			}
			
			//fetching saving account
			@GetMapping("/search_sa_holder")
			public Savings_Account search_sa(HttpSession session) {
			    String s1 = (String) session.getAttribute("name");
			    return sas.SAccount(s1);  // returns null if not found, object if found
			}
			
			//fetching fd account
			@GetMapping("/search_fd_holder")
			public Fixed_Deposit_Account search_fd(HttpSession session,Fixed_Deposit_Account fda) {
				fds.setDate(fda);
			    String s1 = (String) session.getAttribute("name");
			    return fds.FDAccount(s1);  // returns null if not found, object if found
			   
			}
			
			
		
}

