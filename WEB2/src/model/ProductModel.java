package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

import controller.MyConnect;
import entities.Product;

public class ProductModel {
	Product sanpham;
	Part file;
	
	public ProductModel(Part file) {
		this.file = file;
	}

	public ProductModel() {

	}

	public ProductModel(Product sanpham) {
		this.sanpham = sanpham;
	}
	
	public ArrayList<Product> getList() {
		ArrayList<Product> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn == null)
			return null;
		try {
			String sql = "select * from SANPHAM";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Product temp = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				list.add(temp);
			}
			ps.close();
			cn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public Product getProductByMasp(String masp) {
		Connection cn = new MyConnect().getcn();
		Product pro = null;
		if(cn == null)
			return null;
		try {
			String sql = "select * from SANPHAM where masp = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, masp);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				pro = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
			ps.close();
			cn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pro;
	}
	
	public String getFileName(Part filepart) {
		String filename = "";
		String header = filepart.getHeader("Content-Disposition");
		System.out.println("Header : " + header);
		int beginIndex = header.lastIndexOf("=");
		filename = header.substring(beginIndex + 1);
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = p.matcher(filename);
		while(m.find())
			filename = m.group(1);
		beginIndex = filename.lastIndexOf("\\");
		filename = filename.substring(beginIndex + 1);
		System.out.println("Filename : " + filename);
		return filename;
	}
	
	public void uploadFile(String uploadRootPath) {
		try {
			InputStream fis = file.getInputStream();
			byte[] data = new byte[fis.available()];
			fis.read(data);
			FileOutputStream fos = new FileOutputStream(new File(uploadRootPath) + "\\" + getFileName(file));
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			System.out.println("That bai");
			System.out.println(e.getMessage());
		}
		System.out.println("Thanh cong");
	}
	
}
