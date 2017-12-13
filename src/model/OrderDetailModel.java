package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.MyConnect;
import entities.OrderDetail;

public class OrderDetailModel {
	OrderDetail detail;

	public OrderDetailModel(OrderDetail detail) {
		this.detail = detail;
	}

//	them order detail
	public int insertOrderDetail() {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		try {
			String sql = "insert into orderdetail values(?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, detail.getOrder_id());
			ps.setString(2, detail.getProduct_id());
			ps.setInt(3, detail.getQuantity());
			kq = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kq;
	}
}
