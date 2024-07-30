package controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/authenticationfilter")

public class AuthenticationFilters implements Filter{
	private FilterConfig config;
	
	public void init(FilterConfig config) throws ServletException{
		this.config = config;
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;

	    // Check if the request is a login or logout request
	    
	    String uri = req.getRequestURI();
		boolean isLoginJsp = uri.toLowerCase().endsWith("Login.jsp");
		System.out.println(isLoginJsp+"  JSP LOGIN");
		boolean isLoginServlet = uri.endsWith("LoginServlet");
		System.out.println(isLoginServlet+"  SERVLET LOGIN");
		boolean isLogoutServlet = uri.endsWith("LogoutServlet");
		System.out.println(isLogoutServlet+"  SERVLET LOGOUT");
		boolean isRegisterJsp = uri.endsWith("Register.jsp");
		System.out.println(isRegisterJsp+"    JSP REGISTER");
		boolean isUserRegisterServlet = uri.endsWith("Register");
		System.out.println(uri.contains("css")+"   csss");
		
		
		 boolean isLoginPage = uri.toLowerCase().endsWith("login.jsp") || uri.endsWith("LoginServlet");
	       boolean isRegisterPage = uri.toLowerCase().endsWith("register.jsp") || uri.endsWith("RegisterServlet");
	       
	       
	    HttpSession session = req.getSession(false);
	    boolean loggedIn = session != null && session.getAttribute("user") != null;
	    System.out.println(loggedIn+"   logged in");
	    

	    /*if (!loggedIn && !(isLoginJsp || isUserRegisterServlet || isLoginServlet || isRegisterJsp)) {
	        // If not logged in and not accessing login/register pages, redirect to login
	        res.sendRedirect(req.getContextPath() + "/pages/Login.jsp");
	    } else if (loggedIn && (isRegisterJsp || isLoginJsp || isUserRegisterServlet)) {
	        // If logged in and accessing login/register pages, redirect to homepage
	        res.sendRedirect(req.getContextPath() + "/pages/Homepage.jsp");
	    } else if (!loggedIn && !(isLoginJsp || isUserRegisterServlet || isLoginServlet || isRegisterJsp)) {
	        // If not logged in and accessing other pages, redirect to login
	        res.sendRedirect(req.getContextPath() + "/pages/Login.jsp");
	    } else {
	        // Otherwise, continue with the filter chain
	        chain.doFilter(request, response);
	    }*/
	    if (!loggedIn ) {
            res.sendRedirect(req.getContextPath()+"/pages/Homepage.jsp");
        } else {
            chain.doFilter(req, res);
        }

	}

	
}
