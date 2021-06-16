package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.bean.ProductBean;
import com.dao.ProductDao;

@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;     

	@GetMapping("/newproduct")
	public String newProduct(Model model) {
		model.addAttribute("product", new ProductBean());
		return "NewProduct";
	}
	 

	@PostMapping("/saveproduct")
	public String saveProduct(@ModelAttribute("product") @Valid ProductBean product, BindingResult result,
			Model model) {

		if (result.hasErrors()) {

			model.addAttribute("product", product);
			return "NewProduct";
		} else {
			// insert into db
			productDao.insertProduct(product);
			model.addAttribute("msg", "Product Added");
			return "Home";

		}

	}

	@GetMapping("/listproducts")
	public String getAllProducts(Model model) {

		List<ProductBean> products = productDao.getAllProducts();
		model.addAttribute("products", products);
		return "ListProduct";
	}

	@GetMapping("/deleteproduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId) {
		productDao.deleteProductById(productId);
		return "redirect:/listproducts";
	}

	@GetMapping("/editproduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId, Model model) {
		ProductBean product = productDao.getProductById(productId);
		model.addAttribute("product", product);
		return "NewProduct";
	}
	
	@PostMapping("/updateproduct")
	public String updateProduct(@ModelAttribute("product") @Valid ProductBean product, BindingResult result,
			Model model) {

		if (result.hasErrors()) {

			model.addAttribute("product", product);
			return "EditProduct";
		} else {
			// insert into db
			productDao.updateProduct(product);
			model.addAttribute("msg", "Product Modified successfully....");
			return "Home";

		}

	}

	

}
