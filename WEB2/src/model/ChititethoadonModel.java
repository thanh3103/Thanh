package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.MyConnect;
import entities.Chitiethoadon;

public class ChititethoadonModel {
	Chitiethoadon cthd;

	public ChititethoadonModel() {
		
	}

	public ChititethoadonModel(Chitiethoadon cthd) {
		this.cthd = cthd;
	}
	
	public int insertChiTietHoaDon() {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if(cn == null)
			return 0;
		try {
			String sql = "insert into CHITIETHOADON values (?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, cthd.getMahd());
			ps.setString(2, cthd.getMasp());
			ps.setInt(3, cthd.getSoluong());
			kq = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kq;
	}
}
