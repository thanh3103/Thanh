package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.ProductModel;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	ProductModel promodel;
	String hinhsp;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String message = "";
		String page = "";
		HttpSession session = request.getSession();
		String masp = request.getParameter("txtmasp");
		String tensp = request.getParameter("txttensp");
		String giasp = request.getParameter("txtgiasp");
//		String hinhsp = "";
		Connection cn = new MyConnect().getcn();
		if(cn == null)
			return ;
		if(action.equals("upload"))
		{
			Part file = request.getPart("file");
			ProductModel pm = new ProductModel(file);
			hinhsp = pm.getFileName(file);
			String uploadRootPath = request.getServletContext().getRealPath("Images");
			pm.uploadFile(uploadRootPath);
			page = "insert.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
		if(action.equals("uploadupdate"))
		{
			Part file = request.getPart("file");
			ProductModel pm = new ProductModel(file);
			hinhsp = pm.getFileName(file);
			String uploadRootPath = request.getServletContext().getRealPath("Images");
			pm.uploadFile(uploadRootPath);
			page = "update.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
		if(action.equals("insert"))
		{	
			String madm = request.getParameter("txtmadm");
			int kq = 0;
			try {
				String sql = "insert into SANPHAM values (?,?,?,?,?)";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, masp);
				ps.setString(2, tensp);
				ps.setString(3, giasp);
				ps.setString(4, hinhsp);
				ps.setString(5, madm);
				kq = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if(kq == 0)
			{
				message = "Insert that bai";
				page = "Error.jsp";
			}
			else
			{
				page = "index.jsp";
			}
			request.setAttribute("thong bao", message);
			request.getRequestDispatcher(page).forward(request, response);
		}
		if(action.equals("update"))
		{
			String madm = request.getParameter("madm");
			cn = new MyConnect().getcn();
			int kq = 0;
			if(cn == null)
				return;
			try {
				String sql = "update SANPHAM set TENSP=?,GIA=?,HINH=?,MADM=? where MASP=?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, tensp);
				ps.setString(2, giasp);
				ps.setString(3, hinhsp);
				ps.setString(4, madm);
				ps.setString(5, masp);
				kq = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if(kq == 0)
			{
				message = "Update that bai";
				page = "Error.jsp";
			}
			else
			{
				page = "index.jsp";
			}
			request.setAttribute("thong bao", message);
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
