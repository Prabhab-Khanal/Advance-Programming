<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Star Store | Nepal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/home.css" />
</head>
<body>

<jsp:include page="/pages/Header.jsp"/>

<section>
  <div class="heading">
    <div class="text-container">
      
      <h2>Unlock boundless potential with our cutting-edge graphics cards.</h2>
      <div class="btns">
        <a href="${pageContext.request.contextPath}/pages/Aboutus.jsp"><button>Learn More</button></a>
        <a href="${pageContext.request.contextPath}/displayProduct"><button>Buy Now</button></a>
      </div>
    </div>
  </div>
</section>

<p class="heading-title">Shop all latest graphics cards</p>

<jsp:include page="/pages/Footer.jsp"/>
</body>
</html>
