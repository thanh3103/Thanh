package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Item;
import entities.Order;
import entities.OrderDetail;
import model.CartModel;
import model.OrderDetailModel;
import model.OrderModel;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CartModel cartModel = new CartModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		if (action.equals("add")) {
			cartModel.addList(id);
		} else if (action.equals("delete")) {
			cartModel.removeProduct(id);
		} else if (action.equals("removeall")) {
			cartModel.removeAll();
		}
		request.setAttribute("listItem", cartModel.getListItem());
		request.setAttribute("totalcart", cartModel.totalList());
		request.getServletContext().setAttribute("totalcart", cartModel.totalList());
		request.getRequestDispatcher("usercart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		String createDate = dateFormat.format(cal.getTime());
		Order order = new Order(0, createDate);

		// insert 1 order
		OrderModel orderModel = new OrderModel(order);
		int total = (int) request.getServletContext().getAttribute("totalcart");
		
		orderModel.insertOrder(total);

		// lay order_id vua tao
		int newestIdOrder = orderModel.getNewestIdOrder();

		// insert order detail
		ArrayList<Item> items = cartModel.getListItem();
		for (Item item : items) {
			OrderDetail orderDetail = new OrderDetail(newestIdOrder, item.getProduct().getId(), item.getQuantity());
			OrderDetailModel detailModel = new OrderDetailModel(orderDetail);
			detailModel.insertOrderDetail();
		}
		
		//insert thanh cong, xoa gio hang
		cartModel.removeAll();
		request.getRequestDispatcher("/JDBC").forward(request, response);

	}

}
