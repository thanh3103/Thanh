package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Product;

/**
 * Servlet implementation class JDBC
 */
@WebServlet("/JDBC")
public class JDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Integer page = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JDBC() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		List<Product> products = new ArrayList<Product>();
		Integer offset = 0;
		if (request.getParameter("page") == null) {
			page = 0;
		} else {
			page = Integer.valueOf(request.getParameter("page"));
		}
		Connection cn = new MyConnect().getcn();
		try {
			String sql = "select * from products limit ?,?";
			PreparedStatement ps = cn.prepareStatement(sql);
			offset = (page - 1) * 8;
			if(offset < 0)
				offset = 0;
			ps.setInt(1, offset);
			ps.setInt(2, 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				products.add(product);
			}
			Integer count = products.size();
			Integer pages = count / 8;
			request.setAttribute("pages", pages);
			request.setAttribute("count", count);
			request.setAttribute("offset", offset);

			request.setAttribute("products", products);
			request.getRequestDispatcher("store.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
