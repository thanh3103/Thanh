package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Danhmuc;
import entities.Product;
import model.DanhmucModel;

/**
 * Servlet implementation class DanhmucServlet
 */
@WebServlet("/DanhmucServlet")
public class DanhmucServlet extends HttpServlet {
	DanhmucModel dmmodel;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhmucServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String madm = request.getParameter("madm");
		String action = request.getParameter("action");
		String page = "";
		String message = "";
		String tendm = request.getParameter("tendm");
		if (action.equals("view")) {
			dmmodel = new DanhmucModel();
			ArrayList<Product> listsp = dmmodel.getProductByMadm(madm);
			request.setAttribute("listsp", listsp);
			page = "ViewProduct.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
		if (action.equals("delete")) {
			dmmodel = new DanhmucModel();
			int kq = dmmodel.updateDeleted(madm);
			if(kq == 0) {
				page = "Error.jsp";
			}
			else{
				page = "ViewDanhMuc.jsp";
			}
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String page = "";
		String message = "";
		if (action.equals("insert")) {
			String tendmuc = request.getParameter("txttendmuc");
			dmmodel = new DanhmucModel();
			int kq = dmmodel.insertDanhMuc(tendmuc);
			if (kq == 0) {
				message = "Insert that bai";
				page = "Error.jsp";
			} else {
				page = "ViewDanhMuc.jsp";
			}
			request.setAttribute("thongbao", message);
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
