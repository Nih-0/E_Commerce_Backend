package com.nihal.ecom_proj1.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nihal.ecom_proj1.model.product;
import com.nihal.ecom_proj1.repo.productrepo;

@Service
public class productservice {
	
	
	@Autowired
	private productrepo repo;

	public List<product> getallproduct() {
		
		return repo.findAll();
		
	}

	public product getproductbid(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(new product());  //or else is used to handle in case of missing values
	}

	public product addproduct(product product, MultipartFile image) throws IOException {
		product.setImagename(image.getOriginalFilename());
		product.setImagetype(image.getContentType());
		product.setImagedata(image.getBytes());
		return repo.save(product);
	}

	public product updateproduct(int id, product product, MultipartFile image) throws IOException {
		
		product.setImagedata(image.getBytes());
		product.setImagename(image.getOriginalFilename());
		product.setImagetype(image.getContentType());
		return repo.save(product);
	}

	public void deleteproduct(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	public List<product> searchproduct(String keyword) {
		return repo.searchproduct(keyword);
	}

	

	
	

}
