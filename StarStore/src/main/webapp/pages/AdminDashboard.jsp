<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:include page="Header.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Star Store | Nepal</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/adminDashboard.css" />
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<body>
    <header>
        <img src="${pageContext.request.contextPath}/resources/logo/dashboard icon.png" alt="Logo">
        <a>Dashboard</a>
        <button>Logout</button>
    </header>

    <section>
    	<form action="${pageContext.request.contextPath}/seeUserList" method="post">
        	<button>
           		<h1>User List</h1>
        	</button>
        </form>
		<form action="${pageContext.request.contextPath}/seeProductList" method="post">
        <button>
            <h1>Product List</h1>
        </button>
		</form>
		
		<form action="${pageContext.request.contextPath}/pages/addProduct.jsp" method="post">
        <button>
            <h1>Add Product</h1>
        </button>
		</form>

		<form action="${pageContext.request.contextPath}/checkOrderStatusAdmin" method="post">
        <button>
            <h1>Order Status</h1>
        </button>
        </form>

        
    </section>
</body>

</html>
<jsp:include page="Footer.jsp"></jsp:include>