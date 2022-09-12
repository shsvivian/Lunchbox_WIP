package model;

import java.time.LocalDate;

public class Dish {

	private Long dishId;
	private String name;
	private Double price;
	private String description;
	private String picture;
	
	protected Dish() {
		
	}
	
	public Dish(long dishId, String name, Double price, String description, String picture) {
		super();
		this.dishId = dishId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.picture = picture;
	}

	public Dish(String name, Double price, String description, String picture) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.picture = picture;
	}
	
	public Long getDishId() {
		return dishId;
	}

	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (dishId ^ (dishId >>> 32));
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (dishId != other.dishId)
			return false;
		return true;
	}
}
