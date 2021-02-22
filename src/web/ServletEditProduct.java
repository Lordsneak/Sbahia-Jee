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
 * Servlet implementation class ServletEditProduct
 */
@WebServlet("/editproduct")
public class ServletEditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditProduct() {
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

		Integer id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Integer quantite = Integer.parseInt(request.getParameter("quantite"));
		Integer price = Integer.parseInt(request.getParameter("price"));
		String image = request.getParameter("image");
		
		ProductImp dp = new ProductImp();
		Product rs = new Product(id , name, description,quantite,price,image);
		try {
			dp.updateProduct(rs);
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
