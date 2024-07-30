<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/login.css">
  </head>
  <body>
    <div class="center">
      <h1>Login</h1>
      <% String errorMessage =(String) request.getAttribute("errorMessage");
        if(errorMessage != null && !errorMessage.isEmpty()){
      %>
        <p class="error-message"><%=errorMessage%></p>
        <%
        } 

        else{
            %> 
            <p></p>
        <%
        }
        %>
      <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <div class="txt_field">
          <input type="text" name="username"required>
          <span></span>
          <label>Username</label>
        </div>
        <div class="txt_field">
          <input type="password" name= "password" required>
          <span></span>
          <label>Password</label>
        </div>
        <div class="pass"><a href="${pageContext.request.contextPath}/pages/Homepage.jsp">Guest Login</a></div>
        <input type="submit" value="Login">
        <div class="signup_link">
          Not a member? <a href="./Register.jsp">Signup</a>
        </div>
      </form>
    </div>
  </body>
</html>