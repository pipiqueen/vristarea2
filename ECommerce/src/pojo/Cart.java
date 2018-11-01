package pojo;

import java.time.LocalDateTime;
import java.util.List;

public class Cart {
	private String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public List<ItemCart> getItemCart() {
		return itemCart;
	}
	public void setItemCart(List<ItemCart> itemCart) {
		this.itemCart = itemCart;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getDateLastUpdated() {
		return dateLastUpdated;
	}
	public void setDateLastUpdated(LocalDateTime dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}
	private List<ItemCart> itemCart;
	private String status;
	private double totalPrice;
	private LocalDateTime dateCreated;
	private LocalDateTime dateLastUpdated;
}
