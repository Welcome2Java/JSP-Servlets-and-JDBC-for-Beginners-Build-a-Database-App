package com.nicfit.jdbc;

public class Nicfit {
	private int id;
	private String name;
	private String type;
	private int quantity;
	private String cost;
	private String CardSet;
	
	public Nicfit(String name, String type, int quantity, String cost, String CardSet) {
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.cost = cost;
		this.CardSet = CardSet;
	}

	public Nicfit(int id, String name, String type, int quantity, String cost, String set) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.cost = cost;
		this.CardSet = set;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getCardSet() {
		return CardSet;
	}

	public void setCardSet(String set) {
		this.CardSet = set;
	}

}
