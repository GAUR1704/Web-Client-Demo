package com.prowings.webclientdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MyWebClientService {
	
	private final WebClient webClient;
	
	@Autowired
	public MyWebClientService(WebClient webClient) {
		this.webClient = webClient;
	}


	public Mono<String> getProduct() {
		return webClient.get()
				.uri("/products/1")
				.retrieve()
				.bodyToMono(String.class);
	}


	public Flux<String> getAllProducts() {
		
		return webClient.get()
				.uri("/products")
				.retrieve()
				.bodyToFlux(String.class);
	}

}
