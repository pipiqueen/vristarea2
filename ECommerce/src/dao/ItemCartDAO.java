package dao;

import java.util.List;

import pojo.Cart;
import pojo.Item;
import pojo.ItemCart;

public interface ItemCartDAO {
	public List<ItemCart> getAllItemCartsByCart(Cart cart);
	public void createItemCart(Item item, int count, double price);
}
