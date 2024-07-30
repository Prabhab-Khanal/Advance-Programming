<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/register.css" />
<title>Insert title here</title>
</head>
<body>
    <section class="container">
    <% 
    String errorMessage =(String) request.getAttribute("errorMessage");
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
      <header>Registration Form</header>
      <form action="${pageContext.request.contextPath}/Register" class="form" method="post">
        <div class="input-box">
          <label>User Name</label>
          <input type="text" placeholder="Enter User Name" name="userName"required />
        </div>

        <div class="input-box">
          <label>First Name</label>
          <input type="text" placeholder="Enter First Name" name="firstName" required />
        </div>

        <div class="input-box">
          <label>Middle Name</label>
          <input type="text" placeholder="Enter Middle Name" name="middleName" />
        </div>

        <div class="input-box">
          <label>Last Name</label>
          <input type="text" placeholder="Enter Last Name" name="lastName" required />
        </div>


        <div class="input-box">
          <label>Email Address</label>
          <input type="text" placeholder="Enter email address" name="email"required />
        </div>

        <div class="input-box">
          <label>Password</label>
          <input type="password" placeholder="Enter Password" name="password" required />
        </div>
		
		<div class="input-box">
          <label>ReType-Password</label>
          <input type="password" placeholder="Enter Password" name="retypePassword" required />
        </div>
		
        <div class="column">
          <div class="input-box">
            <label>Phone Number</label>
            <input type="number" placeholder="Enter phone number" name="phoneNumber" required />
          </div>
          <div class="input-box">
            <label>Birth Date</label>
            <input type="date" placeholder="Enter birth date" name="birthdate" required />
          </div>
        </div>
        <div class="gender-box">
          <h3>Gender</h3>
          <div class="gender-option">
            <div class="gender">
              <input type="radio" id="check-male" name="gender" value="male" />
              <label for="check-male">Male</label>
            </div>
            <div class="gender">
              <input type="radio" id="check-female" name="gender" value="female"/>
              <label for="check-female">Female</label>
            </div>
            <div class="gender">
              <input type="radio" id="check-other" name="gender" value="other" />
              <label for="check-other">Other</label>
            </div>
          </div>
        </div>
        <div class="input-box address">
          <label>Address</label>
          <input type="text" placeholder="Enter street address" name="address" required />
        </div>
        <button>Submit</button>
      </form>
    </section>
  </body>
  
</html>