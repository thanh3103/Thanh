package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MyConnect;
import entities.Product;

public class ProductModel {
	Product product;

	public ProductModel(Product product) {
		this.product = product;
	}

	public ProductModel() {

	}

	// lấy list product
	public ArrayList<Product> getList() {
		ArrayList<Product> products = new ArrayList<Product>();
		Connection cn = new MyConnect().getcn();
		if (cn == null)
			return null;
		try {
			String sql = "select * from products";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return products;
	}

	// lấy 1 sp theo id
	public Product getProductById(String id) {
		Product product = null;
		Connection cn = new MyConnect().getcn();
		if (cn == null)
			return null;
		try {
			String sql = "select * from products where id = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
			ps.close();
			cn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return product;
	}
}
