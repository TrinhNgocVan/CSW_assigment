package org.aptech.t2004e.manager;



//import org.aptech.t2004e.common.dto.BankAccountDto;
import org.aptech.t2004e.config.ServiceProperties;
import org.aptech.t2004e.dto.ProductDto;
import org.aptech.t2004e.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class ProductManager {
	@Autowired
	private RestHelper restHelper;

	@Autowired
	private ServiceProperties serviceProperties;

	public List<ProductDto> gets(){
		log.info("process=get-all-products");
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-products-get"), HttpMethod.GET, new ParameterizedTypeReference<List<ProductDto>>() {});
		return (List<ProductDto>)response.getBody();
	}
	public ProductDto getById(long id) {
		log.info("process=get-product, id={}", id);
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-products-get-by-id"), HttpMethod.GET, ProductDto.class, id);
		return (ProductDto) response.getBody();
	}
	public Boolean delete(long id ){
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-products-delete") , HttpMethod.DELETE ,Boolean.class,id);
		return (Boolean) response.getBody();
	}
	public ProductDto save(ProductDto e ){
		ResponseEntity<?> response = null ;
		if(e.getId() == null){
			 response = restHelper.send(serviceProperties.getPaths().get("api-products-create") , HttpMethod.POST , e, ProductDto.class);
		}else {
			response = restHelper.send(serviceProperties.getPaths().get("api-products-update") , HttpMethod.PUT ,e , ProductDto.class,e.getId());
		}
		return (ProductDto) response.getBody();
	}

}
