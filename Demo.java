package ShopTask;

import java.util.Scanner;

public class Demo {
	
	public static void main(String[] args) {
		
		Shop shop = new Shop("Bakaliq", "Tyrgovishte", 5000);
		
		BulkProduct banani = new BulkProduct("Bananas", 4.5);
		BulkProduct kafe = new BulkProduct("Coffee", 12.8);
		BulkProduct qbulki = new BulkProduct("Apples", 2);
		BulkProduct fystyk = new BulkProduct("Peanuts", 5.5);
		BulkProduct krastavici = new BulkProduct("Cucumber", 1.8);
		
		PieceProduct snikers = new PieceProduct("Snickers", 0.8);
		PieceProduct mlqko = new PieceProduct("Milk cart", 3.2);
		PieceProduct shokolad = new PieceProduct("Chocolate bar", 1.2);
		PieceProduct dyvka = new PieceProduct("Gum", 0.6);
		PieceProduct hlqb = new PieceProduct("Bread", 0.95);
		
		shop.addProduct(banani);
		shop.addProduct(fystyk);
		shop.addProduct(shokolad);
		shop.addProduct(hlqb);
		shop.addProduct(mlqko);
		shop.addProduct(banani);
		
		
		Customer gosho = new Customer("Georgi", shop, 58, 3);
		Customer atanas = new Customer("Atanas", shop, 12, 4);
		
		gosho.addProductInCart(hlqb);
		gosho.addProductInCart(shokolad);
		gosho.addProductInCart(fystyk);
		
		System.out.println();
		System.out.println("=======");
		
		gosho.cartInfo();
		
		System.out.println();
		System.out.println("=======");
		
		gosho.removeProductFromCart(hlqb);
		
		System.out.println();
		System.out.println("=======");
		
		gosho.cartInfo();
		
		gosho.payForProducts();
		System.out.println();
		System.out.println("=======");
		
		shop.printShopInfo();
		
	}

}
