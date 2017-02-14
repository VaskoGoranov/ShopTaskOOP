package ShopTask;

public class PieceProduct extends Product {
	
	private int quantity;
	
	public PieceProduct(String name, double price) {
		//TODO validation
		super(name, price);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
