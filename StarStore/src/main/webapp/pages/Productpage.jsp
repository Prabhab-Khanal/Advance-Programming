<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/productpage.css" />
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>


    <main>


<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

        
<c:forEach var="product" items="${listProducts}">
	
        <div class="product">
            <img src="http://localhost:8080/images/${product.product_image}" alt="Product 1">
            <h1>${product.productName}</h1>
            <p>${product.description}</p>
            <h2><a>Price:-</a>$ ${product.price}</h2>
           <form action="${pageContext.request.contextPath}/pages/askQuantity.jsp" method="post">
            <input type="hidden" name="productId" value="${product.productId}">
            <button type="submit">Add To Cart</button>
        </form>
        </div>

 </c:forEach>
    </main>
</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>