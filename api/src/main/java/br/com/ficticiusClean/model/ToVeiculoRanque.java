package br.com.ficticiusClean.model;

public class ToVeiculoRanque implements Comparable<ToVeiculoRanque> {

	private String name;
	private String brand;
	private String model;
	private int year_of_manufacture;
	private double fuel_spent;
	private double total_spent;

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getYear_of_manufacture() {
		return year_of_manufacture;
	}

	public double getFuel_spent() {
		return fuel_spent;
	}

	public double getTotal_spent() {
		return total_spent;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear_of_manufacture(int year_of_manufacture) {
		this.year_of_manufacture = year_of_manufacture;
	}

	public void setFuel_spent(double fuel_spent) {
		this.fuel_spent = fuel_spent;
	}

	public void setTotal_spent(double total_spent) {
		this.total_spent = total_spent;
	}

	@Override
	public int compareTo(ToVeiculoRanque o) {
		if (this.total_spent < o.getTotal_spent())
			return -1;
		if (this.total_spent > o.getTotal_spent())
			return 1;

		return 0;

	}

}
