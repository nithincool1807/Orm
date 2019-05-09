package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.model.Product;
import com.app.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductDao dao;
	
	@Transactional
	public void saveProduct(Product p) {
		dao.saveProduct(p);
	}

	@Transactional
	public void updateProduct(Product p) {
		dao.updateProduct(p);

	}

	@Transactional
	public void deleteProduct(Integer prodId) {
		dao.deleteProduct(prodId);
	}

	@Transactional(readOnly =true)
	public Product getProductById(Integer prodId) {
		return dao.getProductById(prodId);
	}

	@Transactional(readOnly =true)
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

}
