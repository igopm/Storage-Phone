package com.sp.jdbc.model;

import java.util.Date;

/**
 * @author Maschikevich Igor
 * @version 1.0
 */
public class Phone implements Comparable<Phone> {
	private Long id;
	private String brand;
	private String model;
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Phone() {
		super();
	}

	public Phone(String brand, String model, Date date) {
		super();
		this.brand = brand;
		this.model = model;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Phone [brand = " + brand + ", model = " + model + ", date = "
				+ date + "]";
	}

	@Override
	public int compareTo(Phone o) {
		return this.brand.compareTo(o.getBrand());
	}

	public boolean isNew() {
		return id == null;
	}
}
