package model;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Item;
import entities.Product;

public class CartModel {
	HashMap<String, Item> cart = new HashMap<String, Item>();

	public CartModel() {

	}

	public HashMap<String, Item> getCart() {
		return cart;
	}

	public void setCart(HashMap<String, Item> cart) {
		this.cart = cart;
	}

	public CartModel(HashMap<String, Item> cart) {
		this.cart = cart;
	}

	// them sp vao gio hang
	public void addList(String id) {
		if (cart.containsKey(id)) {
			Item item = cart.get(id);
			int count = item.getQuantity();
			count = count + 1;
			item.setQuantity(count);
		} else {
			Product product = new ProductModel().getProductById(id);
			Item item = new Item(product, 1);
			cart.put(id, item);
		}
	}

	// xoa 1 sp trong gio hang
	public void removeProduct(String id) {
		cart.remove(id);
	}

	// xoa tất cả sp trong giỏ hàng
	public void removeAll() {
		cart.clear();
	}

	// tổng tiền trong giỏ hàng
	public int totalList() {
		int total = 0;
		for (Item item : cart.values()) {
			total = total + (item.getProduct().getPrice() * item.getQuantity());
		}
		return total;
	}

	public ArrayList<Item> getListItem() {
		ArrayList<Item> items = new ArrayList<Item>();
		for (Item item : cart.values()) {
			items.add(item);
		}
		return items;
	}
}
