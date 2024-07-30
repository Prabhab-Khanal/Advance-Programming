package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import model.UserModel;
import utils.StringUtils;

/**
 * Servlet implementation class editUserInfo
 */
@WebServlet("/editUserInfo")
public class editUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
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
		
		Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("firstName", firstName);
        userInfo.put("middleName", middleName);
        userInfo.put("lastName", lastName);
        userInfo.put("dob", birthdate1);
        userInfo.put("gender", gender);
        userInfo.put("email", email);
        userInfo.put("phoneNumber", phoneNumber);
        userInfo.put("address", address);
        userInfo.put("username", username);
        
        int result=dbController.updateUser(userInfo);
        if(result>0) {
        	response.sendRedirect(request.getContextPath()+"/pages/Homepage.jsp");
        }
	}

}
