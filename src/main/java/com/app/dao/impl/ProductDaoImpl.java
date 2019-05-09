package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IProductDao;
import com.app.model.Product;

@Repository
public class ProductDaoImpl implements IProductDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	public void saveProduct(Product p) {
		ht.save(p);
	}

	public void updateProduct(Product p) {
		ht.update(p);
	}

	public void deleteProduct(Integer prodId) {
		Product p=new Product();
		p.setProdId(prodId);
		ht.delete(p);
	}

	public Product getProductById(Integer prodId) {
		//select * from product where pid=?
		Product p=ht.get(Product.class, prodId);
		return p;
	}

	public List<Product> getAllProducts() {
		List<Product> plist= ht.loadAll(Product.class);
		return plist;
	}

}



