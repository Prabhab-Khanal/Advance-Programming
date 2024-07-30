package utils;

import java.io.File;

public class StringUtils {
	public static final String USER_NAME = "userName"; 
	public static final String FIRST_NAME = "firstName"; 
	public static final String LAST_NAME ="lastName";
	public static final String MIDDLE_NAME ="middleName";
	public static final String BIRTHDAY = "birthdate";
	public static final String GENDER = "gender"; 
	public static final String EMAIL = "email"; 
	public static final String PHONE_NUMBER = "phoneNumber"; 
	public static final String ADDRESS = "address"; 
	public static final String PASSWORD ="password";
	public static final String RETYPE_PASSWORD = "retypePassword"; // End Parameter names
	
	// Start: DB Connection
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/coursework";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";
	// End: DB Connection
	
	public static final String INSERT_USER = "INSERT INTO user_info "+ "(user_name, first_name, middle_name,last_name, dob, gender, email, phone_number, address, password, role) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
	public static final String GET_LOGIN_USER_INFO = "SELECT * FROM user_info WHERE user_name = ?";
	public static final String CHECK_USERNAME_EXISTENCE = "SELECT * FROM user_info WHERE user_name = ?";
	public static final String CHECK_EMAIL_EXISTENCE = "SELECT * FROM user_info WHERE email = ?";
	public static final String CHECK_PHONE_NUMBER_EXISTENCE = "SELECT * FROM user_info WHERE phone_number = ?";
	public static final String CHECK_ROLE = "SELECT role FROM user_info WHERE username = ? AND password = ?";
	public static final String GET_ALL_USER_INFO = "SELECT * FROM user_info";
	public static final String UPDATE_USER = "UPDATE user_info SET first_name=?, middle_name=?, last_name=?, dob=?, gender=?, email=?, phone_number=?, address=? WHERE user_name=?";
	
	
	public static final String INSERT_PRODUCT = "INSERT INTO product_info "+ "(product_ID, product_name, product_description, product_price, product_stock, product_image) " + "VALUES (?, ?, ?, ?, ?, ?)";
	public static final String GET_ALL_PRODUCTS_INFO = "SELECT * FROM product_info";
	public static final String HOMEPAGE_IMG = "SELECT * FROM product_info WHERE product_price=(SELECT MAX(product_price) FROM product_info)";
	public static final String GET_CART_PRODUCTS_INFO = "SELECT * FROM product_info where product_ID = ?";
	public static final String CHECK_PRODUCT_ID_EXISTENCE = "SELECT * FROM product_info WHERE product_id = ?";
	public static final String GET_SEARCHED_PRODUCTS_INFO = "SELECT * FROM product_info WHERE product_name LIKE ?";
	public static final String UPDATE_PRODUCT = "UPDATE product_info " + "SET product_name = ?, product_description = ?, product_price = ?, product_stock = ?, product_image = ? " + "WHERE product_ID = ?";
	public static final String DELETE_PRODUCT = "DELETE FROM product_info WHERE product_id = ?";
	
	//Paths for pages
	public static final String LOGIN_PAGE = "/pages/Login.jsp"; 
	public static final String REGISTER_PAGE = "/pages/Register.jsp"; // End JSP Route
	public static final String addPRODUCT_PAGE = "/pages/addProduct.jsp"; 

	// Start Servlet Route
	public static final String REGISTER_SERVLET = "/RegisterServlet"; // End Servlet Route
	
	//Error Messages 
	public static final String ERROR_MESSAGE = "errorMessage";
	
	
	
	public static final String USER_ADMIN = "admin";
	public static final String PASS_ADMIN = "admin";
	
	
	
	public static final String IMAGE_DIR = "New folder\\tomcat\\webapps\\images\\";
	public static final String IMAGE_DIR_SAVE_PATH = "E:" + File.separator + IMAGE_DIR;
	
	
	
	//For Cart Query
	public static final String CHECK_EMPTY_CART = "SELECT cart_id FROM cart_info where cart_id NOT IN(Select cart_id from order_info)  AND user_name = ?"; 
	public static final String INSERT_CART_VALUES = "INSERT INTO cart_info (user_name) VALUES (?)";
	public static final String INSERT_CART_ITEMS = "INSERT INTO cartitems_info (cart_id,product_id,quantity) VALUES (?,?,?)";
	public static final String CHECK_FOR_SAME_CART = "SELECT * FROM cartitems_info WHERE cart_id = ? AND product_id = ?";
	public static final String DELETE_CART_ITEM = "DELETE FROM cartitems_info WHERE product_id = ? and cart_id = ?";
	public static final String UPDATE_QUANTITY = "UPDATE cartitems_info SET quantity = ? WHERE cart_id = (SELECT cart_id FROM cart_info WHERE user_name = ?)";
	
	public static final String CART_LIST ="SELECT p.product_ID AS Product_ID, p.product_image AS Product_Image, p.product_name AS Product_Name, p.product_price AS Price, ci.quantity AS Quantity FROM product_info p JOIN cartitems_info ci ON p.product_id = ci.product_id WHERE ci.cart_id = ?";
	
	public static final String ADD_ORDER ="INSERT INTO order_info (cart_id,order_date,order_status,total_price) VALUES (?,?,?,?)";
	public static final String RECENT_ORDER = "SELECT p.product_ID AS Product_ID, p.product_name AS Product_Name, p.product_description AS Product_Description, p.product_price AS Price, p.product_image AS Product_Image, ci.quantity AS Quantity FROM order_info o JOIN cartitems_info ci ON o.cart_id = ci.cart_id JOIN product_info p ON ci.product_id = p.product_ID ORDER BY o.order_date DESC";
	public static final String ALL_ORDER_ADMIN= "SELECT o.order_id AS OrderID, o.cart_id AS CartID, o.order_status AS OrderStatus, o.order_date AS OrderDate, ci.product_id AS ProductID, ci.quantity AS Quantity, p.product_name AS ProductName, p.product_description AS ProductDescription, p.product_price AS ProductPrice, p.product_stock AS ProductStock FROM order_info o JOIN cartitems_info ci ON o.cart_id = ci.cart_id JOIN product_info p ON ci.product_id = p.product_ID ORDER BY o.order_date DESC";
}
