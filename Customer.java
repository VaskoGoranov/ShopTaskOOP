package ShopTask;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	
	private String name;
	private Shop shop;
	private double personalMoney;
	private ArrayList<Product> cart;
	private int cartCapacity;
	private int cartCounter;
	
	public Customer(String name, Shop shop, double personalMoney, int cartCapacity) {
		//TODO validation
		this.name = name;
		this.shop = shop;
		this.personalMoney = personalMoney;
		this.cartCapacity = cartCapacity;
		cartCounter = 0;
		cart = new ArrayList<>(this.cartCapacity);
	}
	
	public void addProductInCart (Product product) {
		if (product instanceof BulkProduct && this.shop.getBulks().containsKey(product)) {
			Scanner sc = new Scanner (System.in);
			System.out.println("Please enter amount you wish to buy for " +product.getName()+ ": ");
			Double kilos = sc.nextDouble();
			BulkProduct temp = (BulkProduct) product;
			if (kilos <= this.shop.getBulks().get(temp)) {
				temp.setQuantity(kilos);
				if (this.cartCounter < this.cartCapacity) {
					cart.add(temp);
					cartCounter += 1;
				} 
				else {
					System.out.println("Not enough space in the cart! Please remove some products! ");
				}
			}
			else {
				System.out.println("not enough quantity in the store!");
			}
		} 
		else {
			if (product instanceof PieceProduct && this.shop.getPieces().containsKey(product)) {
				Scanner sc = new Scanner (System.in);
				System.out.println("please enter number of pieces you wish to buy for " +product.getName()+ ": ");
				Integer number = sc.nextInt();
				PieceProduct temp = (PieceProduct) product;
				if (number <= this.shop.getPieces().get(temp)) {
					temp.setQuantity(number);
					if (this.cartCounter < this.cartCapacity) {
						cart.add(temp);
						cartCounter += 1;
					}
					else {
						System.out.println("Not enough space in the cart! Please remove some products! ");
					}
				}
				else {
					System.out.println("not enough quantity in the store!");
				}
			} 
			else {
				System.out.println("No such product in the shop!");
			}
		}
		
		
	}
	
	public void removeProductFromCart (Product product) {
		if (cart.contains(product)) {
			cart.remove(product);
		}
		else {
			System.out.println("No such product in the cart!");
		}
		
	}
	
	public void payForProducts () {
		double bill = 0;
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i) instanceof BulkProduct) {
				BulkProduct temp = (BulkProduct) cart.get(i);
				bill += temp.getPrice()*temp.getQuantity();
			}
			else {
				PieceProduct temp = (PieceProduct) cart.get(i);
				bill += temp.getPrice()*temp.getQuantity();
			}
		}
		
		if (bill > this.personalMoney) {
			System.out.println("Please remove some products from your cart and try paying again!");
		}
		else {
			this.personalMoney -= bill;
			this.shop.setCashDesk(this.shop.getCashDesk() + bill);
			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i) instanceof BulkProduct) {
					BulkProduct temp = (BulkProduct) cart.get(i);
					this.shop.getBulks().put(temp, this.shop.getBulks().get(temp)-temp.getQuantity());
				}
				else {
					PieceProduct temp = (PieceProduct) cart.get(i);
					this.shop.getPieces().put(temp, this.shop.getPieces().get(temp)-temp.getQuantity());
				}
			}
			this.cart.clear();
		}
		
	}
	
	public void cartInfo () {
		double billSoFar = 0;
		for (int i = 0; i < cart.size(); i++) {
			System.out.println(cart.get(i).getName() + " : " + cart.get(i).getPrice());
			if (cart.get(i) instanceof BulkProduct) {
				BulkProduct temp = (BulkProduct) cart.get(i);
				billSoFar += temp.getPrice()*temp.getQuantity();
			}
			else {
				PieceProduct temp = (PieceProduct) cart.get(i);
				billSoFar += temp.getPrice()*temp.getQuantity();
			}
		}
		System.out.println("Bill so far: " + billSoFar);
	}

	
	
	
	
	
}
