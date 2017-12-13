package entities;

public class Order {
	private int id;
	private String createDate;

	public Order() {

	}

	public Order(int id, String createDate) {
		this.id = id;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
