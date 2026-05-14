package mini_bank.Components;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

import jakarta.persistence.*;

@Entity
public class Fixed_Deposit_Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@SequenceGenerator(name="val_generator3",initialValue=3006000,allocationSize=1)
	private long account_number;
	 @NotNull
	 @Column(nullable = false,unique= true)
	private String name;
	 @Min(5000)
	private int balance;
	 @Min(2)
	 @Column(nullable = false)
    private int months;        // period input from user
    private LocalDate start_date;
    private LocalDate end_date;
    
    
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	
	
	
}
