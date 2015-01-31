package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Customer cust;
	
	public Controller() {
        super();
        
        //Hardcoded user, just to make the login work. 
        cust = new Customer("Espen", "Zaal", "1234567890", "espenbz@gmail.com");
        cust.setPassword("Test1234");
        
    }

	/**
	 * Original HttpServlet-method.
	 * Its the first on called upon when a session is created. Since the action parameter is not defined
	 * in the login.jsp-form it will redirect the user to login. 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	/**
	 * Original HttpServlet-method.
	 * Receives the submitted form from login.jsp and calls the checkLoggedIn-method to validate
	 * user before either forwarding to withdraw.jsp or back to login.jsp if it failed.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * <Receive information from the login.jsp>
		 * <Receive request for withdrawing money>
		 */
		if(checkLoggedIn(request, response)){
			request.getRequestDispatcher("./bankingservices.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

		
	}
	
	/*
	 * Checks if the dummy-parameter "action" in the HTML-form is "set". 
	 * It will only be set after the login form has been submitted.
	 * If the login-form has been submitted, then the action parameter should be set to "logginrequest".
	 * The method then calls the users' validateUser method and if successful 
	 * sets a new attribute "validated" with value "isLoggedIn" 
	 */
	private boolean checkLoggedIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String action = request.getParameter("action");

		if(action == null){	//Loginform in login.jsp has now been submitted
			request.getRequestDispatcher("./login.jsp").forward(request, response);

		}else if(action.equals("logginrequest")){ //Loginform is submitted. Runnng validation
			
			if(cust.validateUser(username, password)){
				request.getSession().setAttribute("validated", "isLoggedIn");
			}
			
		}
		return true;
		
	}
	

}
