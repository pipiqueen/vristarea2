package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.EcommerceDAOFactory;
import daoImpl.EcommerceDAOJDBCImpl;
import pojo.Category;
import pojo.Item;

/**
 * Servlet implementation class ServletGetCategories
 */
@WebServlet("/ServletGetCategories")
public class ServletGetCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletGetCategories() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		EcommerceDAOJDBCImpl ecommerceDAO = new EcommerceDAOFactory().createEcommerceDAO(); 
		ArrayList<Category> categories = new ArrayList<Category>();
		ArrayList<Item> productos = new ArrayList<Item>();
		if(!request.getParameter("category").equals(null)) {
		
			int categoryValue = Integer.parseInt(request.getParameter("category"));
		
	
		categories = (ArrayList<Category>) ecommerceDAO.getAllCategories();
		
			if(categoryValue != 0) {
			Category category = categories.get(categoryValue);
			productos = (ArrayList<Item>) ecommerceDAO.getAllItemsByCategory(category.getId());
			
		}
		}//else {
			// hacer metodo
			//productos = ecommerceDAO.getAllItems();
		//}
		
		
		
	
		
		
		
		
		
		request.setAttribute("categories", categories);
		request.setAttribute("productos", productos);
		rd.forward(request, response);
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
