<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Product List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/productlist.css" />
</head>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<body>

<br>
<br>
<br>

<br>

<br>
<br>
<br>

    <h1>Product List</h1>
    <table>
        <thead>
            <tr>
                <th class="id-column">ID</th>
                <th class="image-column">Image</th>
                <th class="name-column">Name</th>
                <th class="desc-column">Description</th>
                <th class="price-column">Price</th>
                <th class="quantity-column">Quantity</th>
                <th class="action-column">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${productList}">
    <tr>
        <td>${product.productId}</td>
        <td><img src="http://localhost:8080/images/${product.product_image}" alt=""></td>
        <td>${product.productName}</td>
        <td>${product.description}</td>
        <td>$${product.price}</td>
        <td>${product.stock}</td>
        <td>
            <form action ="${pageContext.request.contextPath}/pages/updateProduct.jsp" method ="post">
            	<button><img src="${pageContext.request.contextPath}/resources/logo/Edit icon.png" alt="edit"></button>
            </form>
            <form action ="${pageContext.request.contextPath}/pages/deleteProduct.jsp" method ="post">
            	<button><img src="${pageContext.request.contextPath}/resources/logo/delete icon.png" alt="delete"></button>
            </form>
        </td>
    </tr>
</c:forEach>
            

            
            
            <!-- Add more rows as needed -->
        </tbody>
    </table>
</body>
</html>
<jsp:include page="Footer.jsp"></jsp:include>