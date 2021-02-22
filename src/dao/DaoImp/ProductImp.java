package dao.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.DbConnect;
import Model.Product;
import dao.IProduct;


public class ProductImp implements IProduct{
	Connection dbLink;
	@Override
	public Product save(Product a) throws SQLException, ClassNotFoundException {
		dbLink = DbConnect.getConnect();
		try {
			PreparedStatement ps = dbLink.prepareStatement("INSERT INTO public.product(nom, description, quantite, prix, image) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, a.getNom());
			ps.setString(2, a.getDescription());
			ps.setInt(3, a.getQuantite());
			ps.setInt(4, a.getPrix());
			ps.setString(5, a.getImage());
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Product> ProductMc(String mc) throws ClassNotFoundException, SQLException {
		List <Product> productmc = new ArrayList<Product>();
		dbLink = DbConnect.getConnect();
		try {
			PreparedStatement ps = dbLink.prepareStatement
					("SELECT nom FROM product WHERE nom LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product a = new Product();
				a.setId(rs.getInt("id"));
				a.setNom(rs.getString("nom"));
				a.setDescription(rs.getString("description"));
				a.setQuantite(rs.getInt("quantite"));
				a.setPrix(rs.getInt("prix"));
				a.setImage(rs.getString("image"));
				productmc.add(a);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return productmc;
		
		
	}

	@Override
	public Product getProduct(int id) throws ClassNotFoundException, SQLException {
Connection dbLink=DbConnect.getConnect();
		
		Product a = new Product();
       try {
		PreparedStatement ps= dbLink.prepareStatement("SELECT id, nom, description, quantite, prix, image FROM public.product WHERE id= ?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if  (rs.next()) {
			
			a.setId(rs.getInt("id"));
			a.setNom(rs.getString("nom"));
			a.setDescription(rs.getString("description"));
			a.setQuantite(rs.getInt("quantite"));
			a.setPrix(rs.getInt("prix"));
			a.setImage(rs.getString("image"));
		}
			
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		return a;
	}



	@Override
	public Product updateProduct(Product a) throws ClassNotFoundException, SQLException {
		Connection dbLink=DbConnect.getConnect();
	       try {
	    	  
	    	String q = "UPDATE public.product SET nom=?, description=?, quantite=?, prix=?, image=? WHERE id = ?";
	    	
			PreparedStatement ps= dbLink.prepareStatement(q);
			ps.setString(1, a.getNom());
			ps.setString(2, a.getDescription());
			ps.setInt(3, a.getQuantite());
			ps.setInt(4, a.getPrix());
			ps.setString(5, a.getImage());
			ps.setInt(6, a.getId());

			ps.executeUpdate();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void deleteProduct(int id) throws ClassNotFoundException, SQLException {
		 Connection dbLink=DbConnect.getConnect();
	       try {
			PreparedStatement ps= dbLink.prepareStatement("DELETE FROM public.product WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> getAllProduct() throws ClassNotFoundException, SQLException {
		List <Product> allproduct = new ArrayList<Product>();
		dbLink = DbConnect.getConnect();
		try {
			PreparedStatement ps = dbLink.prepareStatement
					("SELECT id, nom, description, quantite, prix, image\r\n" + 
							"	FROM public.product;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product a = new Product();
				a.setId(rs.getInt("id"));
				a.setNom(rs.getString("nom"));
				a.setDescription(rs.getString("description"));
				a.setQuantite(rs.getInt("quantite"));
				a.setPrix(rs.getInt("prix"));
				a.setImage(rs.getString("image"));
				allproduct.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allproduct;
	}

	
	
}
