package model.entities;

import model.exceptions.StockExceptions;

public class Product {
	private String name;
	private double price;
	private Integer quantity;

	public Product(String name, double price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void addProduts(Integer quantity) throws StockExceptions {
		if (quantity <= 0) {
			throw new StockExceptions("Quantity must be greater than zero");
		}

		this.quantity += quantity;
	}

	public void removeProduts(Integer quantity) throws StockExceptions {
		if (this.quantity < quantity) {
			throw new StockExceptions("Not enough products in stock");
		}
		this.quantity -= quantity;
	}

	public double totalValueInStock() {
		return price * quantity;
	}
    @Override
	public String toString() {
		return getName() + ", " + String.format("$ %.2f", getPrice()) + ", " + getQuantity() + " units," + " Total: $"
				+ totalValueInStock();
	}

}
