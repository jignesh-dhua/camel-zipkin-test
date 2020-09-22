package com.oup.example.zipkin.service1.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.DefaultFluentProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oup.example.zipkin.service1.route.TransformerRoute;

@RestController
public class Service1Controller {

	@Autowired
	private CamelContext context;
	
	@PostMapping("/service1")
	public String post(@RequestBody String body) {
		return "Hello From Service1";
	}

	@GetMapping("/service1")
	public String get() {
		
		String response = context.createFluentProducerTemplate()
			.withBody("The Request")
			.to(TransformerRoute.FROM_ENDPOINT)
			.request(String.class);
		
		
		return response;
	}
}
