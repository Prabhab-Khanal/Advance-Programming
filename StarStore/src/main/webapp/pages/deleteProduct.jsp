<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/deleteProduct.css" />
  </head>
  <body>
    <section class="container">
    <form action = "${pageContext.request.contextPath}/pages/AdminDashboard.jsp">
        	<button class = "but"><<</button>
      </form>
      <header>Delete Product</header>
      <form action="${pageContext.request.contextPath}/deleteProduct" class="form">
        <div class="input-box">
          <label>Product ID</label>
          <input type="text" placeholder="Enter Product ID" name="prodID"required />
        </div>
        <button>Delete</button>
      </form>
    </section>
  </body>
</html> 