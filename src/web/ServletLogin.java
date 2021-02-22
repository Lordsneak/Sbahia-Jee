package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Utilisateur;
import dao.ILogin;
import dao.DaoImp.LoginImp;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILogin utilisateur;

	public void init() throws ServletException {

		utilisateur = new LoginImp();
	}

	String emailId = "";
	String password = "";

	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			Utilisateur rs = utilisateur.login(email, password);
			if (rs != null) {
				
				if (rs.getRole().equals("Client")) {
					
					response.sendRedirect("product.jsp");
				}
				
				else {
					if (rs.getRole().equals("Administrateur")) {
						
						response.sendRedirect("admin.jsp");
					}
				}
			}
			else {
				System.out.print("Erreur null");
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
