package controller.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DatabaseController;
import model.ProductModel;
import utils.StringUtils;

/**
 * Servlet implementation class updateProduct
 */

@WebServlet("/updateProductServlet")
@MultipartConfig(fileSizeThreshold =1024*1024*2, //2MB
maxFileSize=1024*1024*10,//10MB,
maxRequestSize=1024*1024*50)
public class updateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String contentType = request.getContentType();
		    System.out.println("Content Type: " + contentType);
			System.out.println(request.getPart("pimg"));
			int productId = Integer.parseInt(request.getParameter("Id"));
			String productName = request.getParameter("name");
			String productDescription = request.getParameter("description");
			float productPrice =Float.parseFloat(request.getParameter("price"));
			int productStock = Integer.parseInt(request.getParameter("stock"));
			Part part = request.getPart("images");
	 		//String fileName = getFileName(part);
			System.out.println("Image that is Updated :   "+part);		
			ProductModel productModel = new ProductModel(productName,productDescription,productPrice,productStock,productId,part);
	 				
	 		// Save the uploaded file to the server
	 		String savePath = StringUtils.IMAGE_DIR_SAVE_PATH;
	 		String fileName = productModel.getImageURLfromPart();
	 		if(!fileName.isEmpty() && fileName != null) {
	 			part.write(savePath+fileName);
	 		}
	 		boolean updated = dbController.updateProduct(productModel);
	 		if (updated) {
	 		    // Product updated successfully
	 		    // Redirect or forward to a success page
	 			request.setAttribute("registerMessage", "Update Successful");
	 			request.getRequestDispatcher("/pages/ProductList.jsp").forward(request, response);
	 		} else {
	 		    // Failed to update product
	 		    // Redirect or forward to an error page
	 			request.setAttribute("registerMessage", "Sorry But Couldn't Update Product Retry!!!!!");
	 			response.sendRedirect(request.getRequestURI());
	 		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request,response);
	}

}
