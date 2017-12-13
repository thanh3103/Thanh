package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.MyConnect;
import entities.Order;

public class OrderModel {
	Order order;

	public OrderModel(Order order) {
		this.order = order;
	}

	// them order
	public int insertOrder(int total) {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null)
			return 0;
		try {
			String sql = "insert into orders(createDate,total) values(?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, order.getCreateDate());
			ps.setInt(2, total);
			kq = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kq;
	}

	public int getNewestIdOrder() {
		Connection cn = new MyConnect().getcn();
		int maxId = 0;
		try {
			String sql = "select MAX(id) from orders";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt(1);
			}
			ps.close();
			cn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return maxId;
	}
}
