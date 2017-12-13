package entities;

public class Product {
	private String id;
	private String name;
	private Integer price;
	private String image;

	public Product() {

	}

	public Product(String id, String name, Integer price, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
