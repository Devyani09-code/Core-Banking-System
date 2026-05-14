package mini_bank.Components;



import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
//@SequenceGenerator(name="val_generator",initialValue=1000000,allocationSize=1)
private long customer_id;
@NotNull
@Column(nullable = false)
private String name;
@NotNull
@Column(nullable = false)
private String password;
private LocalDate date;

public User() {
	
}

public long getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(long customer_id) {
	this.customer_id = customer_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


}
