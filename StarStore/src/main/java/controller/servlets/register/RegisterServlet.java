package controller.servlets.register;

import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.*;
import model.UserModel;
import utils.StringUtils;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String username = request.getParameter(StringUtils.USER_NAME);
        System.out.println(username);
        String firstName = request.getParameter(StringUtils.FIRST_NAME);
        System.out.println(firstName);
        String lastName = request.getParameter(StringUtils.LAST_NAME);
        System.out.println(lastName);
        String middleName = request.getParameter(StringUtils.MIDDLE_NAME);
        System.out.println(middleName);
        String birthdateString = request.getParameter(StringUtils.BIRTHDAY);
        System.out.println(birthdateString);
        LocalDate birthdate1 = LocalDate.parse(birthdateString);
        String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
        System.out.println(phoneNumber);
        String password = request.getParameter(StringUtils.PASSWORD);
        System.out.println(password);
        String retypePassword = request.getParameter(StringUtils.RETYPE_PASSWORD);
        System.out.println(retypePassword);
        String email = request.getParameter(StringUtils.EMAIL);
        System.out.println(email);
		String gender = request.getParameter(StringUtils.GENDER);
		System.out.println(gender);
		String address = request.getParameter(StringUtils.ADDRESS);
		System.out.println(address);
		/*
        if (!isValidName(firstName) || !isValidName(lastName)) {
         
        	String errorMessage="Nigga Your father gave u a shitty FirstName";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, errorMessage);
    		System.out.print(request.getContextPath()+"Yeta Wrong cha 9");
    		//response.sendRedirect(request.getContextPath() + "/pages/register.jsp");
    		request.getRequestDispatcher (StringUtils.REGISTER_PAGE).forward(request, response);
            return;
        }

        if (!isValidUsername(username)) {
        	String errorMessage="Nigga Choose a better name";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, errorMessage);
    		System.out.print("Yeta Wrong cha 8");
    		// Obtain RequestDispatcher for a specific resource (e.g., a JSP page)
    		request.getRequestDispatcher (StringUtils.REGISTER_PAGE).forward(request, response);
            return;

        }

        if (!isValidBirthdate(birthdate1)) {
        	String errorMessage="Nigga I was sleeping who fucked ur mom";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, errorMessage);
    		System.out.print("Yeta Wrong cha 7");
    		request.getRequestDispatcher (StringUtils.REGISTER_PAGE).forward(request, response);
            return;
        }

        if (!isValidPhoneNumber(phoneNumber)) {
        	String errorMessage="Nigga 12digits with a plus ";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, errorMessage);
    		System.out.print("Yeta Wrong cha 6");
    		request.getRequestDispatcher (StringUtils.REGISTER_PAGE).forward(request, response);
            return;
        }

        if (!isValidPassword(password, retypePassword)) {
        	String errorMessage="Nigga use a proper password or elese get fked up";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, errorMessage);
    		System.out.print("Yeta Wrong cha 5");
    		request.getRequestDispatcher (StringUtils.REGISTER_PAGE).forward(request, response);
            return;
        }
*/
        //Check if data already exists in the database
        if (dbController.usernameExists(username) || dbController.emailExists(email) || dbController.phoneNumberExists(phoneNumber)) {
        	//
        	//
        	//
        	//Change error msg
    		request.setAttribute(StringUtils.ERROR_MESSAGE, "Already registered!!!!");
    		System.out.print("Yeta Wrong cha 4");
    		request.getRequestDispatcher (StringUtils.REGISTER_PAGE).forward(request, response);
            return;
        }
        
		
		
		
        // All validations passed, proceed with registration
        
    	UserModel user  = new UserModel(firstName, lastName, middleName, birthdate1, gender, email, phoneNumber, address, username, password);
        
    	int result = dbController.addUser(user);
    	if (result==1) {
    		String successRegisterMessage="Successfully Registered";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, successRegisterMessage);
    		System.out.print("Yeta Wrong cha 1");
            response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
            
        } else if(result == 0) {
        	String errorMessage="An unexpected error ";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, errorMessage);
    		System.out.print("Yeta Wrong cha 2");
    		request.getRequestDispatcher (StringUtils.REGISTER_PAGE).forward(request, response);
        }
        else {
        	String errorMessage="An server error";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, errorMessage);
    		System.out.print("Yeta Wrong cha 3");
    		request.getRequestDispatcher (StringUtils.REGISTER_PAGE).forward(request, response);
        }
    }
	/*
    //Validate name format (does not contain numbers or special characters)
    private boolean isValidName(String name) {
        return name.matches("[A-Za-z]+");
    }

    // Validate username format (minimum length 7, no special characters)
    private boolean isValidUsername(String username) {
        return username.matches("[A-Za-z0-9]{7,}");
    }

    // Validate birthdate (earlier than current date)
    private boolean isValidBirthdate(LocalDate birthdate) {
        return birthdate.isBefore(LocalDate.now());
    }

    // Validate phone number format (+ followed by 12 digits)
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\+\\d{12}");
    }

    // Validate password complexity (at least 1 digit, 1 special character, 1 capital letter, length > 6)
    private boolean isValidPassword(String password, String retypePassword) {
        if (!password.equals(retypePassword)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    */
}


