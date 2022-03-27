package org.aptech.t2004e.controller;

import org.aptech.t2004e.config.ServiceProperties;
import org.aptech.t2004e.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CartController extends BaseController {
	@Autowired
	RestHelper restHelper ;
	@Autowired
	ServiceProperties serviceProperties ;
	
	
}
