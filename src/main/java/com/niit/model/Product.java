package com.niit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Product")
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column
	@NotEmpty(message="Name is required")
	@Size(min=2,message = "Minimum length for name is 2")
	private String pname;
	
	@Column
	@NotEmpty
	private String ptype;
	
	@Column(length = 2000000000)
	@NotEmpty(message="Description is required")
	private String pdesc;
	
	@NotEmpty(message="Link is required")
	@Column
	private String image;
	
	@Column
	@DecimalMin("10")
	@DecimalMax("10000000")
	private float price;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "product")
	private List<Cart> cart;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public Product() {
		super();
		
	}
	
	public Product(String pname, String ptype, String pdesc, String image, float price) {
		super();
		this.pname = pname;
		this.ptype = ptype;
		this.pdesc = pdesc;
		this.image = image;
		this.price = price;
	}
	
	
	
	
	
}
