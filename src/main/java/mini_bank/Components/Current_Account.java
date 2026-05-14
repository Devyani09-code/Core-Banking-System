package mini_bank.Components;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Current_Account extends Account{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long account_number;
@NotNull
@Column(nullable = false,unique= true)
private String name;
@NotNull
@Column(nullable = false)
private int balance;
@Min(0)
private int sum;

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
public int getSum() {
	return sum;
}
public void setSum(int sum) {
	this.sum = sum;
}



}
