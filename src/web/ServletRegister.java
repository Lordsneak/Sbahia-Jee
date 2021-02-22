package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IUtilisateur;
import dao.DaoImp.UtilisateurImp;

/**
 * Servlet implementation class ServletRegister
 */
@WebServlet("/register")

public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletRegister() {
        super();
    }

    private IUtilisateur user;

	public void init() throws ServletException {

		user = new UtilisateurImp();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			user.Register(username, email, password);
			
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
		response.sendRedirect("login.jsp");

	}
}
