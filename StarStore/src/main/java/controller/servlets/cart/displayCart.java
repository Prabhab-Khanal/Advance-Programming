package controller.servlets.cart;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import model.ProductModel;

/**
 * Servlet implementation class displayCart
 */
@WebServlet("/displayCart")
public class displayCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  // Retrieve the session object
		/*System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("We are in display cart Servlet");
		
		HttpSession session = request.getSession();
        // Retrieve the list of product IDs from the session attribute
        int cartID = (int) session.getAttribute("CART_NAME");
		
        ResultSet rs = dbController.getCartInfo(cartID);
        Map<Integer, Map<String, Object>> productMap = new LinkedHashMap<>();
       
        
        try {
            while (rs != null && rs.next()) {
                // Extract data from ResultSet
                String productImage = rs.getString("Product_Image");
                String productName = rs.getString("Product_Name");
                double price = rs.getDouble("Price");
                int quantity = rs.getInt("Quantity");

                // Create a map to hold product information
                Map<String, Object> productInfo = new HashMap<>();
                productInfo.put("Product_Image", productImage);
                productInfo.put("Product_Name", productName);
                productInfo.put("Price", price);
                productInfo.put("Quantity", quantity);

                // Add the product information to the productMap with a unique identifier (e.g., productId)
                // Here, I assume each product has a unique identifier called "productId"
                int productId = rs.getInt("Product_ID") ; // You need to retrieve the productId from the ResultSet
                productMap.put(productId, productInfo);
            }
            
            // Store the productMap in the request attribute
            session.setAttribute("productMap", productMap);
            
            // Forward the request to the JSP page
            request.getRequestDispatcher("/pages/addToCart.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close(); // Close the ResultSet
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        /*
        try {
			if (rs!= null && rs.next()) {
			    // ResultSet is not null and contains at least one row
			    // Set the resultSet attribute in the request
			    request.setAttribute("resultSet", rs);
			    // Forward the request to the JSP page
			    request.getRequestDispatcher("/pages/addToCart.jsp").forward(request, response);
			} else {
			    // ResultSet is either null or empty
			    // Handle this case appropriately
				System.out.println("The Result Set is null");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		HttpSession session = request.getSession();
		// Retrieve the cart ID from the session attribute
		int cartID = (int) session.getAttribute("CART_NAME");
		
		// Get cart information using the updated method
		 Map<Integer, Map<String, Object>>  cartData = dbController.getCartInfo(cartID);

		// Set the cartData attribute in the request
		request.setAttribute("productMap", cartData);
		request.setAttribute("cartID", cartID);
		// Forward the request to the JSP page
		request.getRequestDispatcher("/pages/addToCart.jsp").forward(request, response);
			
	}

}
