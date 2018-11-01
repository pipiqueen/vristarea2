package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.EcommerceDAOJDBCImpl;
import pojo.Category;
import pojo.Item;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		
		EcommerceDAOJDBCImpl ecommerceDAO = new EcommerceDAOJDBCImpl(); 
		ArrayList<Category> categories = new ArrayList<Category>();
		ArrayList<Item> productos = new ArrayList<Item>();
		
		
			productos = (ArrayList<Item>) ecommerceDAO.getAllItemsByCategory(Integer.parseInt(request.getParameter("category")));
			
		
		
		
		
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
