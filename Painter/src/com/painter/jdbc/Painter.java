package com.painter.jdbc;

public class Painter {
	
	private int id;
	private String name;
	private String type;
	private int quantity;
	private String cost;
	private String description;
	private String set;
	
	public Painter(String name, String type, int quantity, String cost, String description, String set) {
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.cost = cost;
		this.description = description;
		this.set = set;
	}

	public Painter(int id, String name, String type, int quantity, String cost, String desciption, String set) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.cost = cost;
		this.description = desciption;
		this.set = set;
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

	public String getDesciption() {
		return description;
	}

	public void setDesciption(String desciption) {
		this.description = desciption;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

}
