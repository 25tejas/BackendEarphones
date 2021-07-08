package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO 
{
	public boolean addProduct(Product Product);
	public boolean deleteProduct(Product Product);
	public boolean updateProduct(Product Product);
	public List<Product> displayProducts();
	public Product displayProduct(int pid);
	public List<Product> findByName(String name);
	public List<Product> findByType(String type);
	public List<Product> displayByPriceDesc();
	public List<Product> displayByPriceAsc();
	
	
}
