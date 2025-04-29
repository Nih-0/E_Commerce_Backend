package com.nihal.ecom_proj1.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data  // Lombok will generate getters, setters, toString, etc.
@Entity
@Table(name = "product")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private String category;
    private boolean available;
    private BigDecimal price;
    private int quantity;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") //this is done to convert the format of date or else it will show in something other format that is not understandable
	
	  private Date releasedate;
    private String imagename;
    private String imagetype;
	  
	  @Lob private byte[] imagedata;
	 
    	
    
    
    

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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
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
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagetype() {
		return imagetype;
	}
	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}
	public byte[] getImagedata() {
		return imagedata;
	}
	public void setImagedata(byte[] imagedata) {
		this.imagedata = imagedata;
	}
	
}
