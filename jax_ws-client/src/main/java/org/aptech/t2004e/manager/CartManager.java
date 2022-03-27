package org.aptech.t2004e.manager;

import lombok.extern.slf4j.Slf4j;
import org.aptech.t2004e.config.ServiceProperties;
import org.aptech.t2004e.dto.ProductDto;
import org.aptech.t2004e.dto.ShoppingCartDto;
import org.aptech.t2004e.util.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartManager {
    @Autowired
    private RestHelper restHelper;

    @Autowired
    private ServiceProperties serviceProperties;
    public ShoppingCartDto getShoppingCart(){
        log.info("get Shopping Cart  ");
        ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-shoppingCart-get"), HttpMethod.GET,ShoppingCartDto.class );
        return (ShoppingCartDto) response.getBody();
    }
    public ShoppingCartDto addItem(Long productId , int quantity){
        ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-shoppingCart-add_item") , HttpMethod.GET,ShoppingCartDto.class , productId , quantity );
        return (ShoppingCartDto) response.getBody();
    }
    public ShoppingCartDto updateItem(Long productId , int quantity){
        ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-shoppingCart-update-item") , HttpMethod.GET,ShoppingCartDto.class , productId , quantity );
        return (ShoppingCartDto) response.getBody();
    }
    public ShoppingCartDto removeItem (Long productId){
        ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-shoppingCart-remove-item") , HttpMethod.GET,ShoppingCartDto.class , productId  );
        return (ShoppingCartDto) response.getBody();
    }
    public ShoppingCartDto clearCart (){
        ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-shoppingCart-clear-cart") , HttpMethod.GET,ShoppingCartDto.class   );
        return (ShoppingCartDto) response.getBody();
    }

}
