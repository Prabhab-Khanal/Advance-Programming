<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add To Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/addToCart.css" />
</head>

<body>
<jsp:include page="Header.jsp"></jsp:include>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>




    <h1>Your Cart</h1>
    <table>
        <thead>
            <tr>
                <th class="image-column">Items</th>
                <th class="name-column"></th>
                <th class="price-column">Price</th>
                <th class="quantity-column">Quantity</th>
                <th class="total-column">Total</th>
                <th class="delete-column"></th>
                
            </tr>
        </thead>
        <tbody>
            
            <c:forEach var="row" items="${resultSet}">
            <tr>
                <td><img src="${row.Product_Image}" alt="Product Image"></td>
                <td>${row.Product_Name}</td>
                <td>$$  ${row.Price}</td>
                <td>${row.Quantity}</td>
                <td>${row.Price * row.Quantity}</td>
                <td><button class="delete-btn"><img src="delete icon.png" alt=""></button>
            </tr>
        </c:forEach>
<c:set var="totalPrice" value="0" />
<c:forEach var="entry" items="${productMap}">
    <tr>
        <td><img src="http://localhost:8080/images/${entry.value.Product_Image}" alt="Product Image"></td>
        <td>${entry.value.Product_Name}</td>
        <td>$$ ${entry.value.Price}</td>
        <td>${entry.value.Quantity}</td>
        <td>${entry.value.Price * entry.value.Quantity}</td>
        <td>
        	<form action="${pageContext.request.contextPath}/deleteCart" method= "post">
        		<input type="hidden" name="productId" value="${entry.key}">
        		<input type="hidden" name="cardId" value="${cartID}">
        		<button class="delete-btn"><img src="${pageContext.request.contextPath}/resources/logo/delete icon.png" alt=""></button>
        	</form>
        </td>
    </tr>
    <c:set var="totalPrice" value="${totalPrice + (entry.value.Price * entry.value.Quantity)}" />
</c:forEach>
            

            <tr>
                <td class="border-white"></td>
                <td class="border-white"></td>
                <td class="border-white">Grand Total:</td>
                <td class="border-white"></td>
                <td class="border-white"> $ ${totalPrice} </td>
            </tr>

            <tr>
                <td class="border-white"></td>
                <td class="border-white"></td>
                <td class="border-white"></td>
                <td class="border-white">
                <form action="${pageContext.request.contextPath}/makeOrderServlet" method= "post">
        			<input type="hidden" name="cardId" value="${cartID}">
        			<input type="hidden" name="price" value="${totalPrice}">
        			<button class="checkout-btn">Checkout</button>
        		</form>
                    
                </td>
                <td class="border-white"> </td>
            </tr>
            

            


            <!-- Add more rows as needed -->
            
        </tbody>
    </table>
    

</body>

</html>

</html>