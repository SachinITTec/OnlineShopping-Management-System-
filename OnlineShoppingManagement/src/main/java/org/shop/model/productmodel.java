package org.shop.model;
import java.math.BigDecimal;
public class productmodel {
    private int id; // This can be optional if auto-generated by the database
    private String name;
    private BigDecimal price;
    private int quantity;
    private int cid;

    // Constructor with name, price, and quantity
    public productmodel(String name, BigDecimal price, int quantity,int cid) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.cid=cid;
    }

    // Getters and setters
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
}