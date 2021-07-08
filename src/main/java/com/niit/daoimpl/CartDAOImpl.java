package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;
import com.niit.model.Product;

@Transactional
@Repository("CartDAO")
public class CartDAOImpl implements CartDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCart(Cart Cart) 
	{
		sessionFactory.getCurrentSession().save(Cart);
		return true;
	}

	public boolean deleteCart(int id) 
	{
		Cart Cart=new Cart();
		Cart.setCid(id);
		sessionFactory.getCurrentSession().delete(Cart);
		return true;
	}
	
	@Override
	public boolean updateCart(Cart cart) 
	{
		sessionFactory.getCurrentSession().update(cart);
		return true;
	}

	@Override
	public Cart getCart(int cid) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from com.niit.model.Cart where cid= :cid");
		return (Cart)query.setParameter("cid", cid).getResultList().get(0);
	}

	public List<Cart> displayCarts(int userid)  
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from CartItem where user.userid= :userid");
			return query.setParameter("userid", userid).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	

	

}
