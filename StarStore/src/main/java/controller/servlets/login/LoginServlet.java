package controller.servlets.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.*;
import utils.StringUtils;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
        String password = request.getParameter("password");
        //response.sendRedirect(request.getContextPath() + "/pages/User.html");
        
        if (!dbController.usernameExists(userName)) {
        	String errorMessage="Error!!!!!";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, errorMessage);
    		//System.out.print("Yeta Wrong cha 4");
    		request.getRequestDispatcher (StringUtils.LOGIN_PAGE).forward(request, response);
            return;
        }
        //System.out.println(dbController.isFound(userName, password));
        if (userName.equals(StringUtils.USER_ADMIN) && password.equals(StringUtils.PASS_ADMIN)) {
     	   try {
     		   response.sendRedirect(request.getContextPath()+"/pages/AdminDashboard.jsp");
     	   }
     	   catch(IOException ex) {
     		   ex.printStackTrace();
     	   }  
        }
        else if(dbController.isFound(userName, password) == 1) {
        	HttpSession session = request.getSession();
        	session.setAttribute("user", userName);
        	
        	session.setMaxInactiveInterval(2*60);
        	
        	Cookie username= new Cookie("user",userName);
        	username.setMaxAge(2*60);
        	response.addCookie(username);
        	
        	response.sendRedirect(request.getContextPath()+"/pages/Homepage.jsp");
        	
        }
        else if(dbController.isFound(userName, password) == -1) {
        	String errorMessage="Server Sided Error!!!!!";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, errorMessage);
    		request.getRequestDispatcher (StringUtils.LOGIN_PAGE).forward(request, response);
        }
        else {
        	String errorMessage="Enter Correct Details!!!";
    		request.setAttribute(StringUtils.ERROR_MESSAGE, errorMessage);
    		request.getRequestDispatcher (StringUtils.LOGIN_PAGE).forward(request, response);
        }
    }
}


