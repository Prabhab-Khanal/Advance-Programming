<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/addUser.css"  />
  </head>
  <body>
    <section class="container">
      <header>Quantity to Add To Cart</header>
      <form action="${pageContext.request.contextPath}/AddToCartServlet" class="form" method="post">
        <div class="input-box">
          <label>Quantity</label>
          <input type="text" placeholder="Enter the desired Quantity you want to order" name ="quantity" required />
          <input type="hidden" name="productId" value="${param.productId}">
        </div>
        <button>Submit</button>
      </form>
    </section>
  </body>
</html>