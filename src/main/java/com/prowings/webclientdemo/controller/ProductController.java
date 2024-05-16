package com.prowings.webclientdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.webclientdemo.service.MyWebClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
	
	@Autowired
	MyWebClientService service;
	
	@GetMapping("/webclient_product")
	public Mono<String> getProduct() {
		
		return service.getProduct();
		
	}
	
	@GetMapping("/webclient_AllProducts")
	public Flux<String> getAllProducts(){
		
		return service.getAllProducts();
	}

}
