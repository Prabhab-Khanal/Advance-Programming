<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Product List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/orderStatusAdmin.css" />
</head>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
    <h1></h1>
    <table class="order-table">
        <thead>
            <tr>
                <th>OrderID</th>
                <th>Cart ID</th>
                <th >Order Status</th>
                <th >Order Date</th>
                <th >Product ID</th>
                <th>Product Name</th>
                <th>Product Description</th>
                <th>Product Price</th>
                <th>Quantity</th>
                <th>Total Price</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="entry" items="${orderMap}">
    <tr>
        <td>${entry.value['OrderID']}</td>
        <td>${entry.value['CartID']}</td>
        <td>${entry.value['OrderStatus']}</td>
        <td>${entry.value['OrderDate']}</td>
        <td>${entry.value['ProductID']}</td>
        <td>${entry.value['ProductName']}</td>
        <td>$ ${entry.value['ProductDescription']}</td>
        <td>$ ${entry.value['ProductPrice']}</td>
        <td>${entry.value['Quantity']}</td>
        <td>${entry.value['ProductPrice'] * entry.value['Quantity']}</td>
    </tr>
    <c:set var="totalPrice" value="${totalPrice + (entry.value['ProductPrice'] * entry.value['Quantity'])}" />
</c:forEach>
        </tbody>
    </table>
</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>
