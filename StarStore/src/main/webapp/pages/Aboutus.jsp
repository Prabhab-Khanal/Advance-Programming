<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/Aboutus.css">
</head>
<body>
 <jsp:include page="/pages/Header.jsp"/>
    <main>
    <br>
    <br>
    <br>
    <br>
        <section class="about-us">
            <h1>About Us</h1>
            <p>
                Welcome to Star Store, your premier destination for all your graphics card needs! At Star Store, 
                we are passionate about technology and dedicated to providing our customers with the latest and most powerful graphics cards on the market.</p>
            <p>As a leading provider of graphics cards through our ecommerce website, we strive to offer an extensive selection of products from top brands, ensuring that enthusiasts, 
                gamers, and professionals alike can find the perfect graphics solution to meet their needs.</p>
            <p>At Star Store, we understand that the right graphics card can make all the difference in unlocking the full potential of your gaming rig or workstation. That's why we carefully curate our inventory to include a diverse range of options, from high-performance GPUs for 
                intense gaming sessions to cutting-edge cards for demanding creative tasks.</p>
            <p>Whether you're a hardcore gamer, a professional content creator, or simply looking to upgrade your PC, Star Store has everything you need to take your computing experience to the next level. Shop with us today and discover
                 why we're the go-to destination for graphics cards online!</p>
            
            
        </section>
        <section class="contact-info">
            <h2>Get in Touch</h2>
            <div class="contact-methods">
                <div class="phone">
                    <i class="fas fa-phone"></i>
                    <p>Phone: 9845074066</p>
                </div>
                <div class="email">
                    <i class="fas fa-envelope"></i>
                    <p>Email: <a href="mailto:StarAutoNP@company.com">info@StarAutoNP.com</a></p>
                </div>
            </div>
            <form>
                <label for="message">Message:</label>
                <textarea id="message" name="message" cols="30" rows="5"></textarea>
                <button type="submit">Send</button>
            </form>
        </section>
    </main>
</body>

</html>