package model;

import java.time.LocalDate;

public class Order {

	private Long id;
	private String name;
	private Double price;
	private String description;
	private LocalDate targetDate;
	
	protected Order() {
		
	}
	
	public Order(long id, String name, Double price, String description, LocalDate targetDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.targetDate = targetDate;
	}

	public Order(String name, Double price, String description, LocalDate targetDate) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.targetDate = targetDate;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
