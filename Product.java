package ShopTask;

public abstract class Product {
	
	private String name;
	private double price;
	public Product(String name, double price) {
		//TODO validation
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
}
