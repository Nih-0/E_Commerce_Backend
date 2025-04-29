package com.nihal.ecom_proj1.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.nihal.ecom_proj1.model.product;
import com.nihal.ecom_proj1.service.productservice;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")


public class productcontroller {
	
	@Autowired
	private productservice service;
	
	
	@GetMapping("/products")          //to return all the product
	public List<product>getallproduct()
	{
		return service.getallproduct();
		
	}
	
	@GetMapping("/products/{id}")
	public product getproduct(@PathVariable int id)
	{
		return service.getproductbid(id);
	}
	
	@PostMapping("/products")
	public product addproduct(@RequestPart product product , @RequestPart MultipartFile image) throws IOException
	{
		return service.addproduct(product, image);
	}
	
	
	
	
	
	
	@GetMapping("/product/{productid}/image")
	public ResponseEntity<byte[]> getimagebyproductid(@PathVariable int productid )  //pathvariable for accepting image and byte because photo will be in byte format
	{
		product product=service.getproductbid(productid);
		byte[] image= product.getImagedata();
			
		return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImagetype())).body(image);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<String>updateproduct(@PathVariable int id, 
			@RequestPart product product , @RequestPart MultipartFile image) throws IOException
	{
		product product1=service.updateproduct(id,product,image);
		if(product1!=null)
		
			return new ResponseEntity<>("done", HttpStatus.OK);
		else
			return new ResponseEntity<>("problem", HttpStatus.BAD_REQUEST);
		
		
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String>deleteproduct(@PathVariable int id)
	{
		product product=service.getproductbid(id);
		if(product!=null)
		{
		service.deleteproduct(id);
			return new ResponseEntity<>("deleted",HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<>("problem occured",HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/products/search")
	public ResponseEntity<List<product>>searchproduct(@RequestParam String keyword)
	{
		List<product> product=service.searchproduct(keyword);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
