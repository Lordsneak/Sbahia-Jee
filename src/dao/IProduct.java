package dao;

import java.sql.SQLException;

import java.util.List;

import Model.Product;

public interface IProduct {

	public Product save(Product a) throws SQLException, ClassNotFoundException;
	public List<Product> ProductMc(String mc) throws ClassNotFoundException, SQLException;
	public Product getProduct(int id) throws ClassNotFoundException, SQLException;
	public List<Product> getAllProduct() throws ClassNotFoundException, SQLException;
	public Product updateProduct(Product a) throws ClassNotFoundException, SQLException;
	public void deleteProduct(int id) throws ClassNotFoundException, SQLException;
}
