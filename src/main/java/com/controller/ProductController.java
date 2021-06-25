package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.service.ImageUploadService;

@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;

	@Autowired
	ImageUploadService imgService;

	@Autowired
	CategoryDao categoryDao;
	
	@GetMapping("/newproduct")
	public String newProduct(Model model, ProductBean bean) {
		model.addAttribute("product", bean);
		model.addAttribute("category",categoryDao.getAllCategories());
		
		return "NewProduct";
	}

	@PostMapping("/saveproduct")
	public String saveProduct(@ModelAttribute("product") @Valid ProductBean product, BindingResult result, Model model,
			@RequestParam("productImage") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		if (result.hasErrors()) {

			model.addAttribute("product", product);
			return "NewProduct";
		} else {
			// insert into db
			System.out.println(product.getCategoryId());
			int productId = productDao.insertProduct(product);
			product.setProductId(productId);

			String dir = "D:\\Tejas Shah\\Dropbox\\Tejas Shah's Workplace\\work\\21-au-spring-web\\src\\main\\webapp\\resources\\images\\"
					+ product.getProductId();

			imgService.uploadData(file, dir);
			product.setImgPath(
					"21-au-spring-web/resources/images/" + product.getProductId() + "/" + file.getOriginalFilename());
			productDao.addImage(product.getImgPath(), product.getProductId());
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

	@GetMapping("/addproductimage/{id}")
	public String addProductImage(Model model, @PathVariable("id") int id) {
		ProductBean product = new ProductBean();
		product.setProductId(id);
		model.addAttribute("product", product);

		return "NewProductImage";
	}

	@PostMapping("/uploadimage")
	public String uploadImage(@RequestParam("productImage") MultipartFile file,
			@RequestParam("productId") int productId) {
		System.out.println("-----uploading start------");
		String dir = "D:\\Tejas Shah\\Dropbox\\Tejas Shah's Workplace\\work\\21-au-spring-web\\src\\main\\webapp\\resources\\images\\"
				+ productId;
		File f = new File(dir);
		if (f.exists()) {
			String s[] = f.list();
			for (String fn : s) {
				File fdelete = new File(dir, fn);
				if (fdelete.isFile())
					fdelete.delete();
			}
		}

		imgService.uploadData(file, dir);
		productDao.addImage("21-au-spring-web/resources/images/" + productId + "/" + file.getOriginalFilename(),
				productId);
		return "redirect:/listproducts";
	}

}
