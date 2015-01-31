package model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class BankAccount {

	private String accountno;
	private double balance;
	private Map<Calendar, String> trHistory;
	
	public BankAccount(String accountno, double balance) {

		this.accountno = accountno;
		this.balance = balance;
		trHistory = new HashMap<>();
	}
	
	/**
	 * Method receives a request to withdraw money.
	 * If withdrawal is possible then it logs the transaction and completes the request.
	 * @param amount
	 * @return
	 */
	public boolean withdrawMoney(int amount){
		if(validateWithdrawal(amount)){
			balance -= amount;
			Calendar now = Calendar.getInstance();
			trHistory.put(now, "Withdrawal of " + amount);
			return true;
		}
		return false;
	}
	
	/**
	 * Private method that validates if the requested withdrawal amount
	 * is less that the account balance.
	 * @param amount
	 * @return
	 */
	private boolean validateWithdrawal(int amount){
		if((int)balance - amount > 0){
			return true;
		}
		return false;
	}

	public double getBalance() {
		return balance;
	}

	public Map<Calendar, String> getTrHistory() {
		return trHistory;
	}
	
	
	
}
