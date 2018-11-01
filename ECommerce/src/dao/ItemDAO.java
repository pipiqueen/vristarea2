package dao;

import java.util.List;

import pojo.Item;

public interface ItemDAO {
	public Item getItemDetail(int id);
	public List<Item> getAllItemsByCategory(int category);
}
