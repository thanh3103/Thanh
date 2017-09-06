package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.MyConnect;
import entities.Danhmuc;
import entities.Product;

public class DanhmucModel {
	Danhmuc dm;

	public DanhmucModel() {

	}

	public DanhmucModel(Danhmuc dm) {
		this.dm = dm;
	}

	public Danhmuc getDm() {
		return dm;
	}

	public void setDm(Danhmuc dm) {
		this.dm = dm;
	} 

	public ArrayList<Danhmuc> getList() {
		ArrayList<Danhmuc> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn == null)
			return null;
		try {
			String sql = "select * from DANHMUC where DELETED=0";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Danhmuc temp = new Danhmuc(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(temp);
			}
			ps.close();
			cn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public ArrayList<Product> getProductByMadm(String madm) {
		ArrayList<Product> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn == null)
			return null;
		try {
			String sql = "select * from SANPHAM where MADM = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, madm);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Product temp = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				list.add(temp); 
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public int insertDanhMuc(String tendm) {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if(cn == null)
			return 0;
		try {
			String sql = "insert into DANHMUC values (?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, tendm);
			ps.setInt(2, 0);
			kq = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kq;
	}
	
	public int updateDeleted(String madm) {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if(cn == null)
			return 0;
		try {
			String sql = "update DANHMUC set DELETED=? where MADM=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, madm);
			kq = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kq;
	}

}
