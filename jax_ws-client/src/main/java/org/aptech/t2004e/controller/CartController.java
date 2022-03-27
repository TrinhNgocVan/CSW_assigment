package org.aptech.t2004e.controller;

import lombok.Getter;
import org.aptech.t2004e.config.ServiceProperties;
import org.aptech.t2004e.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class CartController extends BaseController {
	@Autowired
	RestHelper restHelper ;
	@Autowired
	ServiceProperties serviceProperties ;
	@GetMapping("/carts/{userId}")
	public ModelAndView getCart(@PathVariable int userId , HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("");
		return null;
	}




	
}
