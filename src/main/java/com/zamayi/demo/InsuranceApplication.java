package com.zamayi.demo;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class InsuranceApplication {

	public static void main(String... args) {
		SpringApplication.run(InsuranceApplication.class, args);
	}
	
	
	@Autowired
	private RuntimeService runtimeService;
	
	@EventListener
	private void postDeploy(PostDeployEvent e) {
		this.runtimeService.startProcessInstanceByKey("insuranceApplication");
	}
}
