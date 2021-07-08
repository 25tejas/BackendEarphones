package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO
{
	public boolean addCart(Cart cart);
	public boolean deleteCart(int cid);
	public boolean updateCart(Cart cart);
	public List<Cart> displayCarts(int userid);
	public Cart getCart(int cid);
}
