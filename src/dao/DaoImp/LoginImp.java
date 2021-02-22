package dao.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DbConnect;
import Model.Utilisateur;
import dao.ILogin;

public class LoginImp implements ILogin{
	Statement statement = null;
	public static int id_Session = 0;
	
	@Override
	public Utilisateur login(String email, String password) throws ClassNotFoundException, SQLException {
		Utilisateur utilisateur = null;
		try {
			String query = "SELECT * FROM public.\"accounts\" where \"email\"=? and \"password\"=?";
			Connection con = DbConnect.getConnect();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			
			
			if (rs.next()) {
				if (rs.getString(5).equals("Administrateur")) {
					utilisateur = new Utilisateur(rs.getString(2), email, password, rs.getString(5));
					id_Session = (rs.getInt(1));
				} else {
					if (rs.getString(5).equals("Client")) {
						utilisateur = new Utilisateur(rs.getString(2), email, password, rs.getString(5));
						id_Session = (rs.getInt(1));
					}
				}
				
				utilisateur.setId((rs.getInt(1)));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return utilisateur;
		
	}

}
