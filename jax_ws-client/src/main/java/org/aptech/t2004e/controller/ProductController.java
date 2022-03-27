package org.aptech.t2004e.controller;
import org.aptech.t2004e.config.ServiceProperties;
import org.aptech.t2004e.dto.ProductDto;
import org.aptech.t2004e.manager.ProductManager;
import org.aptech.t2004e.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class ProductController extends BaseController {
	@Autowired
	RestHelper restHelper ;
	@Autowired
	ServiceProperties serviceProperties ;
	@Autowired
	ProductManager productManager;
	@GetMapping("/products")
		public ModelAndView list(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView("product-list");
		modelAndView.addObject("products", productManager.gets());
		return modelAndView;
	}
	@GetMapping("/product/delete/{id}")
	public String delete(@PathVariable Long id, HttpServletRequest request) throws Exception {
		if(productManager.delete(id) == true){
			addMessage(request,"Xóa sản phẩm thành công ");
		}else{
			addError(request,"Xoá sản phẩm thất bại");
		}
		String view  ="redirect:/products";
		return view ;
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/product/form")
	public ModelAndView form(@RequestParam(value = "id",required = false) Long id, HttpServletRequest request) throws Exception {
		log.debug("entering 'form' employee method...");
		ProductDto product = new ProductDto();
		if(id != null){
			product = productManager.getById(id);
		}
		ModelAndView modelAndView = new ModelAndView("product-form");
		modelAndView.addObject("product" , product);
		return modelAndView;
	}
	@PostMapping("/product/save")
	public String save(@ModelAttribute("product") ProductDto p , BindingResult binding , HttpServletRequest request) throws Exception {
		log.info("process='save' method, {}", p);
		if(binding.hasErrors()){
			addError(request , "Lưu thông tin sản phẩm thất bại");
		}else{
			ProductDto savedProductDto = productManager.save(p);
			if(savedProductDto != null){
				addMessage(request , "Cập nhật thông tin sản phẩm thành công ");
			}else{
				addError(request , "Cập nhật thông tin sản phẩm thất bại ");
			}
		}
		String view = "redirect:/products";
		return view;
	}
}
