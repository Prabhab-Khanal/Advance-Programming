package model;

public class CartitemsModel {
	private int productID;
	private int cartID;
	private int quantity; 
	
	public CartitemsModel() {
	// TODO Auto-generated constructor stub
		super();
	}
	public CartitemsModel(int productID, int cartID, int quantity) {
		this.cartID=cartID;
		this.productID = productID;
		this.quantity=quantity;
	}
}
