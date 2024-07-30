package controller.servlets.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import model.ProductModel;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseController dbController = new DatabaseController();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
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
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		//List listProductCart = new ArrayList(); 
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		HttpSession session = request.getSession();
		String user= (String) session.getAttribute("user");
		System.out.println("Product Added to cart (Product_id): "+productId);
		System.out.println("Product Added to cart(uSer) : "+user);
		

		if (dbController.getCartID(user)== 0) {
			System.out.println("1  :::::  MA CHIRYO");
		    // If the cart doesn't exist for the user, create a new cart
		    int result_cart = dbController.addNewCart(user);
		    if (result_cart > 0) {
		        // Cart creation successful
		        int cart_id = dbController.getCartID(user);
		        if (cart_id > 0) {
		            // Cart ID retrieved successfully
		            int result_cart_items = dbController.addCartItems(cart_id, productId,quantity);
		            if (result_cart_items > 0) { 
		                // Product added to cart successfully
		                request.getRequestDispatcher("/displayProduct").forward(request, response);
		                session.setAttribute("CART_NAME",cart_id );
		            } else {
		                // Failed to add product to cart
		            	response.sendRedirect(request.getContextPath()+"/pages/Homepage.jsp");
		            }
		        } else {
		            // Failed to retrieve cart ID
		        	response.sendRedirect(request.getContextPath()+"/displayProduct");
		        }
		    } else {
		        // Failed to create new cart
		    	response.sendRedirect(request.getContextPath()+"/pages/Login.jsp");
		    }
		} else {
			System.out.println("2  :::::  MA CHIRYO");
		    // If the cart exists for the user, check if the product already exists in the cart
		    int cart_id = dbController.getCartID(user);
		    if (cart_id > 0) {
		        // Cart ID retrieved successfully
		        if (!dbController.checkForSameProduct(cart_id, productId)) {
		            // Product doesn't exist in cart, add it
		            int result_cart_items = dbController.addCartItems(cart_id, productId,quantity);
		            if (result_cart_items > 0) {
		                // Product added to cart successfully
		                request.getRequestDispatcher("/displayProduct").forward(request, response);
		                session.setAttribute("CART_NAME",cart_id );
		            } else {
		                // Failed to add product to cart
		            	response.sendRedirect(request.getContextPath()+"/pages/Homepage.jsp");
		            }
		        } else {
		            // Product already exists in cart
		        	response.sendRedirect(request.getContextPath()+"/displayProduct");
		        }
		    } else {
		        // Failed to retrieve cart ID
		    	response.sendRedirect(request.getContextPath()+"/pages/Login.jsp");
		    }
		}
		
		/*if(!dbController.checkCart(user)) {
			System.out.println("rechecking here"+dbController.checkCart(user));
			int result_cart= dbController.addNewCart(user);
			int cart_id = dbController.getCartID(user);
			System.out.println("Product Added to cart(CArtID) : "+cart_id);
			int result_cart_items = dbController.addCartItems(cart_id,productId);
			request.getRequestDispatcher("/pages/fine2.html").forward(request, response);
		}
		else {
			System.out.println("its in else");
			int cart_id = dbController.getCartID(user);
			System.out.println("Product Added to cart(CArtID222) : "+cart_id);
			System.out.println("Check for the cartItems number"+dbController.checkForSameProduct(cart_id, productId));
			if (!dbController.checkForSameProduct(cart_id, productId)) {
				System.out.println("whta willit br"+dbController.checkForSameProduct(cart_id, productId));
				int result_cart_items = dbController.addCartItems(cart_id,productId);
				request.getRequestDispatcher("/pages/fine.html").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/pages/error.html").forward(request, response);
			}
			
		}*/
	}

}
