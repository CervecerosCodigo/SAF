package model;

public class Customer {

	private static int custNoGenerator = 10000;
	private int custNo;
	private String firstName;
	private String lastName;
	private String accountNo;
	private String emailAdr;
	private String password;
	
	public Customer(){}
	
	
	
	public Customer(String firstName, String lastName, String accountNo, String emailAdr) {
		
		custNo = custNoGenerator++;
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNo = accountNo;
		this.emailAdr = emailAdr;
	}

	
	/**
	 * When Controller get a login-request, it identifies the user and 
	 * asks the Customer-object to verify the login.
	 * @param username
	 * @param password
	 */
	public boolean validateUser(String username, String password){
		if(username.equals(emailAdr) && password.equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getEmailAdr() {
		return emailAdr;
	}

	public void setEmailAdr(String emailAdr) {
		this.emailAdr = emailAdr;
	}

	public int getCustNo() {
		return custNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	
}
