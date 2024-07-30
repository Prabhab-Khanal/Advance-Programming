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
      <header>Authorize User</header>
      <form action="#" class="form">
        <div class="input-box">
          <label>User Name</label>
          <input type="text" placeholder="Enter User Name" name ="user_name"required />
        </div>
        <button>Submit</button>
      </form>
    </section>
  </body>
</html>