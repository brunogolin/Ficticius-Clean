package br.com.ficticiusClean.model;

public class ToVeiculo {

	private String name;
	private String brand;
	private String model;
	private int year_of_manufacture;
	private double avg_consumption_city;
	private double avg_consumption_road;

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

	public double getAvg_consumption_city() {
		return avg_consumption_city;
	}

	public double getAvg_consumption_road() {
		return avg_consumption_road;
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

	public void setAvg_consumption_city(double avg_consumption_city) {
		this.avg_consumption_city = avg_consumption_city;
	}

	public void setAvg_consumption_road(double avg_consumption_road) {
		this.avg_consumption_road = avg_consumption_road;
	}

}
