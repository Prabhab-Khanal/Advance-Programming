<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Star Store | Nepal</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/header.css" />

</head>

<body>
    <nav>
          <img src="${pageContext.request.contextPath}/resources/logo/Logo.png" alt="Logo" >
        <ul>
            <li><a href="${pageContext.request.contextPath}/pages/AdminDashboard.jsp"><img src= "${pageContext.request.contextPath}/resources/logo/home.png"></a></li>
        </ul>
        

            <div class="dropdown">
                <button class="dropbtn"><img class="profile-icon" src="${pageContext.request.contextPath}/resources/logo/Profile icon.png" alt="hello"></button>
                <div class="dropdown-content">
                    <a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
                </div>
			</div>
    </nav>
</body>

</html>