package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Transactional
@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product Product) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(Product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product Product) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(Product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
			
	}

	@Override
	public boolean updateProduct(Product Product) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(Product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Product> displayProducts() 
	{
		return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
	}

	@Override
	public Product displayProduct(int pid) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from com.niit.model.Product where pid= :pid");
		return (Product)query.setParameter("pid", pid).getResultList().get(0);
	}

	@Override
	public List<Product> findByName(String name) 
	{
		Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product where pname like :name or ptype like :name");
		query.setParameter("name", "%"+name+"%");
		return (List<Product>)query.getResultList();
	}

	@Override
	public List<Product> findByType(String type) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from com.niit.model.Product where ptype='"+type+"'");
		return (List<Product>)query.getResultList();
	}

	@Override
	public List<Product> displayByPriceAsc() 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from com.niit.model.Product order by price asc");
		return (List<Product>)query.getResultList();
	}

	@Override
	public List<Product> displayByPriceDesc() 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from com.niit.model.Product order by price desc");
		return (List<Product>)query.getResultList();
	}

}
