package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dao.*;
import pojo.Cart;
import pojo.Category;
import pojo.Item;
import pojo.ItemCart;

public class EcommerceDAOJDBCImpl implements CartDAO, CategoryDAO, ItemCartDAO, ItemDAO {

	private Context ic;
	private DataSource ds;
	private Connection con = null;
	private PreparedStatement stmt = null;
	private PreparedStatement stmt2 = null;
	private ResultSet rs = null;

	public EcommerceDAOJDBCImpl() {

		try {

			ic = new InitialContext();

			ds = (DataSource) ic.lookup("java:comp/env/jdbc/examenweb");

		} catch (Exception e) {

			System.out.println("Error al hacer lookup " + e.getMessage());

		}

	}

	@Override
	public Item getItemDetail(int id) {
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(
					"SELECT * FROM productos WHERE ID=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			Item item = new Item();
			item.setDescription(rs.getString("SHORT_DESCRIPTION"));
			item.setCategory(rs.getInt("CATEGORIES"));
			item.setId(rs.getInt("ID"));
			item.setImage(rs.getString("IMAGES_URL"));
			item.setName(rs.getString("NAME"));
			item.setPrice(rs.getLong("PRICE_TAX_EXCLUDE"));
			return item;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> getAllItemsByCategory(int category) {
		List<Item> items = new ArrayList<Item>();
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(
					"SELECT * FROM productos WHERE CATEGORIES = ?");
			stmt.setLong(1, category);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Item item = new Item();
				item.setDescription(rs.getString("SHORT_DESCRIPTION"));
				item.setCategory(rs.getInt("CATEGORIES"));
				item.setId(rs.getInt("ID"));
				item.setImage(rs.getString("IMAGES_URL"));
				item.setName(rs.getString("NAME"));
				item.setPrice(rs.getLong("PRICE_TAX_EXCLUDE"));
				items.add(item);
			}
			return items;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ItemCart> getAllItemCartsByCart(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createItemCart(Item item, int count, double price) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("SELECT * FROM categorias");

			rs = stmt.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("nombre"));
				categories.add(category);
			}
			return categories;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getCategoryName(int id) {
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("SELECT nombre FROM categories WHERE id=?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			
			return rs.getString("nombre");
			

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cart> getAllCartsByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getPendingCartByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCart(String user, List<ItemCart> itemCart, String status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCart(String user, List<ItemCart> itemCart, String status, LocalDateTime dateLastUpdated) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroyCart(Cart cart) {
		// TODO Auto-generated method stub

	}

}
