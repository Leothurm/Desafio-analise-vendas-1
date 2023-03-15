package entities;

public class Sales {

	private Integer month;
	private Integer year;
	private	String sales;
	private	Integer items;
	private	Double total;
	
	public Sales() {
		
	}
	
	public Sales(Integer month, Integer year, String sales, Integer items, Double total) {
		this.month = month;
		this.year = year;
		this.sales = sales;
		this.items = items;
		this.total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	public Double getTotal() {
		return total;
	}

	public void setTota(Double tota) {
		this.total = tota;
	}
	
	public Double averagePrice() {
		return total/items;
	}

	@Override
	public String toString() {
		return  month + "/" +  year + ", " + sales + ", " + items + ", " + total + ", pm = " + String.format("%.2f", averagePrice()) ;
	}
	
	
	
}
