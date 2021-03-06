package ia.demo.po;

import java.io.Serializable;


public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1282478334946171815L;
	//id
	private long id;
	//名字
	private String name;
	//编号
	private String isbn;
	//价格
	private double price;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
