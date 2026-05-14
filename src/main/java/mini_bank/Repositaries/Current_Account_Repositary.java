package mini_bank.Repositaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mini_bank.Components.Current_Account;
import mini_bank.Components.Savings_Account;
import mini_bank.Components.User;
public interface Current_Account_Repositary extends JpaRepository<Current_Account,Long>{
@Query(" from Current_Account ca where ca.name=:name")
Current_Account findByName(@Param ("name") String name);

@Query("select ca.sum,ca.balance from Current_Account ca where ca.account_number=:account_number")
Current_Account getTransaction(@Param ("account_number") Long account_number);
}
