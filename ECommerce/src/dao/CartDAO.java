package dao;

import java.time.LocalDateTime;
import java.util.List;

import pojo.Cart;
import pojo.ItemCart;

public interface CartDAO {
	public List<Cart> getAllCartsByUser(String user);
	public Cart getPendingCartByUser(String user);
	public void createCart(String user, List<ItemCart> itemCart, String status);
	public void updateCart(String user, List<ItemCart> itemCart, String status, LocalDateTime dateLastUpdated);
	public void destroyCart(Cart cart);
}
