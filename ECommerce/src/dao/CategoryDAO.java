package dao;

import java.util.List;

import pojo.Category;

public interface CategoryDAO {
	public List<Category> getAllCategories();
	public String getCategoryName(int id);
}
