package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import dao.DaoImp.ProductImp;

/**
 * Servlet implementation class ServletAddProduct
 */
@WebServlet("/addproduct")
public class ServletAddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ProductImp dao = new ProductImp();
		try {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Integer quantite = Integer.parseInt(request.getParameter("quantite"));
			Integer price = Integer.parseInt(request.getParameter("price"));
			String image = request.getParameter("image");
			
			dao.save(new Product(name,description,quantite,price,image));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/SBahia/admin.jsp");
		
	}
	}