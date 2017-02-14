package ShopTask;

public class BulkProduct extends Product {
	
	private double quantity; 
	
	public BulkProduct(String name, double price) {
		//TODO validation
		super(name, price);
		
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
