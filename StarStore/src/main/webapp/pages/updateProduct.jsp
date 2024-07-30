<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
  <head>
  
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/updateProduct.css" />
  </head>
  <body>
  
    <section class="container">
    <form action = "${pageContext.request.contextPath}/pages/AdminDashboard.jsp">
        	<button class = "but"><<</button>
      </form>
      <header>Update Product</header>
            <form action="${pageContext.request.contextPath}/updateProductServlet" class="form" method="post" enctype="multipart/form-data">
        <div class="input-box">
          <label>Product Name</label>
          <input type="text" placeholder="Enter Product Name" name="name"required />
        </div>

        <div class="input-box">
          <label>ID</label>
          <input type="text"  name="Id" required />
        </div>

        <div class="input-box">
          <label>Description</label>
          <input type="text" placeholder="Description" name="description"required />
        </div>

        <div class="input-box">
          <label>Price</label>
          <input type="text" placeholder="Enter Price" name="price"required />
        </div>


        <div class="input-box">
          <label>Stock</label>
          <input type="text" placeholder="Enter Stock" name="stock"required />
        </div>

        <div class="form-group">
            <label for="images">Images:</label>
            <input type="file" id="images" name="images" multiple required>
        </div>

        
		
        <button>Update</button>
      </form>
    </section>
  </body>
</html>