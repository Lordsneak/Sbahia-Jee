package dao.DaoImp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DbConnect;
import Model.Utilisateur;
import dao.IUtilisateur;

public class UtilisateurImp implements IUtilisateur {

	@Override
	public Utilisateur Register(String username, String password, String email)
			throws ClassNotFoundException, SQLException {
		Utilisateur user = null;
		String requete="INSERT INTO public.\"accounts\"(\"username\", \"password\", \"email\", \"role\") VALUES (?, ?, ?, ?);";
		PreparedStatement statement = DbConnect.getConnect().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, username);
		statement.setString(2, password);
		statement.setString(3, email);
		statement.setString(4, "Client");
		statement.executeUpdate();
		
		user = new Utilisateur(username, password, email);
		
		return user;
	}

}
