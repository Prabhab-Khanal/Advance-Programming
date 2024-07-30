package model;

import java.time.LocalDate;

public class OrderModel {
	private int orderID;
	private int orderQuantity;
	private LocalDate orderDate;
	private float totalPrice;
	private String orderStatus;
	
	public OrderModel() {
		super();
	}
	public OrderModel(int orderID, int orderQuantity, LocalDate orderDate, float totalPrice, String orderStatus) {
		this.orderID =orderID;
		this.orderQuantity=orderQuantity;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
