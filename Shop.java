package ShopTask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

public class Shop {
	
	private String name;
	private String address;
	private double cashDesk;
	private HashMap<BulkProduct, Double> bulks;
	private HashMap<PieceProduct, Integer> pieces;
	
	public Shop(String name, String address, double cashDesk) {
		//TODO validation
		this.name = name;
		this.address = address;
		this.cashDesk = cashDesk;
		bulks = new HashMap<>();
		pieces = new HashMap<>();
	}

	public void addProduct (Product product) {
		if (product instanceof BulkProduct) {
			Scanner sc = new Scanner (System.in);
			System.out.println("Please add kilos for " +product.getName()+ ": ");
			Double kilos = sc.nextDouble();
			BulkProduct temp = (BulkProduct) product;
			if (bulks.containsKey(temp)){ 
				bulks.put(temp, bulks.get(temp) + kilos);
			} else {
				bulks.put(temp, kilos);
			}
			this.cashDesk -= temp.getPrice() * kilos; 
		} 
		else {
			if (product instanceof PieceProduct) {
				Scanner sc = new Scanner (System.in);
				System.out.println("please enter number of pieces for " +product.getName()+ ": ");
				Integer number = sc.nextInt();
				PieceProduct temp = (PieceProduct) product;
				if (pieces.containsKey(temp)){ 
					pieces.put(temp, pieces.get(temp) + number);
				} 
				else {
					pieces.put(temp, number);
				}
				this.cashDesk -= temp.getPrice() * number;
			}
			else {
				System.out.println("Wrong type of product!");
			}
		}
	}
		
	public void printShopInfo () {
		System.out.println("Shop name: " + this.name);
		System.out.println("Shop address: " + this.address);
		System.out.println("Shop cash desk: " + this.cashDesk + "levs");
		System.out.println("==========================");
		System.out.println("Shop bulks list:" );
		for (Entry<BulkProduct, Double> e : bulks.entrySet()) {
			System.out.println("------------------------");
			System.out.println(e.getKey().getName() + " : " + e.getKey().getPrice() + "levs per kilo - " + e.getValue() + " kilos available");
		}
		System.out.println("==========================");
		System.out.println("Shop pieces list:" );
		for (Entry<PieceProduct, Integer> e : pieces.entrySet()) {
			System.out.println("------------------------");
			System.out.println(e.getKey().getName() + " : " + e.getKey().getPrice() + "levs per piece - " + e.getValue() + " pieces available");
		}
	}

	public HashMap<BulkProduct, Double> getBulks() {
		return bulks;
	}

	public HashMap<PieceProduct, Integer> getPieces() {
		return pieces;
	}

	public double getCashDesk() {
		return cashDesk;
	}

	public void setCashDesk(double cashDesk) {
		this.cashDesk = cashDesk;
	}
	
	
}
