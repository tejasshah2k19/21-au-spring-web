package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

	@GetMapping("/addproductimage")
	public String addProductImage(Model model) {
		model.addAttribute("product", new ProductBean());

		return "NewProductImage";
	}

	@PostMapping("/uploadimage")
	public String uploadImage(@RequestParam("productImage") MultipartFile file) {
		System.out.println("-----uploading start------");
		try {
		String fileName = file.getOriginalFilename();
		System.out.println("file name ==> "+fileName);
		String dir = "D:\\Tejas Shah\\Dropbox\\Tejas Shah's Workplace\\work\\21-au-spring-web\\src\\main\\webapp\\resources\\images\\";
    
		File f  = new File(dir,fileName);//images / 3.jpg
		f.createNewFile();//blank file 
		byte allBytes[] = file.getBytes();
		
		FileUtils.writeByteArrayToFile(f, allBytes);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "redirect:/listproducts";
	}

}






















