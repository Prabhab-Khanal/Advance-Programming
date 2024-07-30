package model;

import java.io.File;

import javax.servlet.http.Part;

import utils.StringUtils;

public class ProductModel {
	private String productName;
	private String description;
	private float price;
	private int stock;
	private int productId;
	private String imageURLfromPart;
	private String product_image;
	
	public ProductModel() {
		super();
	}
	
	public ProductModel(String productName, String description, float price, int stock, int productId, Part part) {
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.productId = productId;
		this.imageURLfromPart = getImageUrl(part);
		
	}
	
	public String getProductName() {
		return productName;
	}
	public String getDescription() {
		return description;
	}
	public float getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public int getProductId() {
		return productId;
	}
	public String getImageURLfromPart() {
		return imageURLfromPart;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setImageURLfromPart(Part part) {
		this.imageURLfromPart = getImageUrl(part);
	}
	
	public void setProductImage(String product_image) {
		this.product_image = product_image;
	}
	
	public String getProduct_image() {
		return product_image;
	}
	private String getImageUrl(Part part) {
		// Method to extract the file name from the "content-disposition" header
	 		String savePath = StringUtils.IMAGE_DIR_SAVE_PATH;
	 		File fileSaveDir = new File(savePath);
	 		String imageUrlFromPart = null;
	 		
	 		if (!fileSaveDir.exists()) 
	 		{
	 			fileSaveDir.mkdir();
	 		}
	 		
	 		String contentDisp = part.getHeader("content-disposition");
	 		String[] items = contentDisp.split(";");
	 		for (String s : items) 
	 		{
	 			if (s.trim().startsWith("filename")) 
	 			{
	 				imageUrlFromPart=s.substring(s.indexOf("=") + 2, s.length() - 1);
	 			}
	 		}
	 		return imageUrlFromPart;
	 	}
}

