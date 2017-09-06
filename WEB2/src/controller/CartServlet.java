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
import javax.servlet.http.HttpSession;

import entities.Chitiethoadon;
import entities.Hoadon;
import entities.Item;
import model.CartModel;
import model.ChititethoadonModel;
import model.HoadonModel;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartModel cartmodel = new CartModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "";
		String action = request.getParameter("action");
		String masp = request.getParameter("masp");
		HttpSession session = request.getSession();
		if(action.equals("add"))
			cartmodel.addList(masp);
		else if(action.equals("delete"))
			cartmodel.removeProduct(masp);
		else if(action.equals("removeall"))
			cartmodel.removeAll();
		request.setAttribute("list", cartmodel.getListItems());
		request.setAttribute("totalcart", cartmodel.totalList());
		page = "usercart.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "";
		String action = request.getParameter("action");
		String masp = request.getParameter("masp");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		String ngaydh = sdf.format(cal.getTime());
		Hoadon hd = new Hoadon(0, ngaydh);
		HoadonModel hdmodel = new HoadonModel(hd);
		hdmodel.insertHoadon();
		int newestidhd = hdmodel.getNewestIdHoadon();
		ArrayList<Item> cart = cartmodel.getListItems();
		for (Item i : cart) {
			Chitiethoadon cthd = new Chitiethoadon(newestidhd, i.getSanpham().getMasp(), i.getSoluong());
			ChititethoadonModel cthdModel = new ChititethoadonModel(cthd);
			cthdModel.insertChiTietHoaDon();
		}
		cartmodel.removeAll();
		page = "index.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

}
