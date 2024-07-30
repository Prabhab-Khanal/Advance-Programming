<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Product List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/userlist.css" />
</head>
<body>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
    <h1>User list</h1>
    <table>
        <thead>
            <tr>
                <th class="sn-column">SN.</th>
                <th class="username-column">UserName</th>
                <th class="firstname-column">First Name</th>
                <th class="middlename-column">Middle Name</th>
                <th class="lastname-column">Last Name</th>
                <th class="email-column">Email Address</th>
                <th class="phone-column">Phone Number</th>
                <th class="birthdate-column">Birth Date</th>
                <th class="gender-column">Gender</th>
                <th class="address-column">Address</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${ListUser}" varStatus="loop">
            <tr>
                <!-- Display the serial number (starts from 1) -->
                <td>${loop.index + 1}</td>
                <!-- Display other user information -->
                <td>${user.username}</td>
                <td>${user.firstName}</td>
                <td>${user.middleName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.dob}</td>
                <td>${user.gender}</td>
                <td>${user.address}</td>
            </tr>
        </c:forEach>

           
            <!-- Add more rows as needed -->
        </tbody>
    </table>
</body>
</html>

</html>