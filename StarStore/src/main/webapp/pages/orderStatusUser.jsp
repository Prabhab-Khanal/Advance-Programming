<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Product List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/orderStatusUser.css" />
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


    <h1>Recently Ordered Products</h1>
    <table class="order-table">
        <thead>
            <tr>
                <th class="product-column">Product Image</th>
                <th>Product Name</th>
                <th >Product description</th>
                <th >Total Quantity</th>
                <th >Total Price</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="entry" items="${orderMap}">
    	<tr>
        	<td class="product-image"><img src="http://localhost:8080/images/${entry.value.Product_Image}" alt="Product Image"></td>
        	<td>${entry.value.Product_Name}</td>
        	<td>$$ ${entry.value.Product_Description}</td>
        	<td>${entry.value.Quantity}</td>
        	<td>${entry.value.Price * entry.value.Quantity}</td>
        	
    </tr>
    <c:set var="totalPrice" value="${totalPrice + (entry.value.Price * entry.value.Quantity)}" />
</c:forEach>
            
        </tbody>
    </table>
</body>
</html>
