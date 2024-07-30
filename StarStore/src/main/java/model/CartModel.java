package model;

public class CartModel {
	private int cartID;
	private float totalPrice;
	public String userName;
	
	public CartModel() {
		super();
	}
	
	public CartModel(int cartID,float totalPrice, String userName) {
		this.cartID=cartID;
		this.totalPrice=totalPrice;
		this.userName=userName;
	}
	public int getCartID() {
		return cartID;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	 public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	 public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
}
