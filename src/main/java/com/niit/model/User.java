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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	@Column
	@Size(min = 4,max = 16)
	@NotEmpty(message = "Username is required")
	private String username;
	
	@Column
	@Pattern(regexp = "^[a-z0-9\\.]+@[a-z]+\\.[a-z]{3}$",message = "Invalid Email Id")
	@NotEmpty(message = "Email is required")
	private String email;
	
	@Column
	@Pattern(regexp = "^\\d{10}$",message = "Invalid Mobile Number")
	private String mobile;
	
	@Column
	@NotEmpty(message = "Email is required")
	private String password;
	
	@Column
	public boolean enabled;
	@Column
	public String authority;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	private List<Cart> cart;
	
	
	public User() {
		super();
	}
	public User(String username,String email,String mobile,String password) {
		super();
		this.username = username;
		this.email=email;
		this.mobile=mobile;
		this.password = password;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	
	
}
