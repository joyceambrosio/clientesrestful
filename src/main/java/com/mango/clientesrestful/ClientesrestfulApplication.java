package com.mango.clientesrestful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ComponentScan
@SpringBootApplication
public class ClientesrestfulApplication extends SpringBootServletInitializer {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesrestfulApplication.class, args);
	}
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ClientesrestfulApplication.class);
    }
}
