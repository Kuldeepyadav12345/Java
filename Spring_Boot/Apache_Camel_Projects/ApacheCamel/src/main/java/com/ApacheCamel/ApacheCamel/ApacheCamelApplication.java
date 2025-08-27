package com.ApacheCamel.ApacheCamel;

import org.apache.camel.CamelContext;
import org.apache.camel.language.bean.Bean;
import org.apache.camel.spi.ExecutorServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages="com.ApacheCamel.ApacheCamel")
@ComponentScan(basePackages={"com.ApacheCamel.ApacheCamel","com.ApacheCamel.ApacheCamel.route"})
@SpringBootApplication
public class ApacheCamelApplication {

	@Autowired 
	CamelContext camelContext;
	
	@Value("${THREAD_NAME_PATTERN")
	private String threadName;
	
	public static void main(String[] args) {
		SpringApplication.run(ApacheCamelApplication.class, args);
		System.out.println("Started");
		
		
	}
	
	@Bean(ref = "")
	ExecutorServiceManager executerServiceManager()
	{
		ExecutorServiceManager executerServiceManager =camelContext.getExecutorServiceManager();
		executerServiceManager.setThreadNamePattern(threadName);
		System.out.println("===============>>>>>>>>>>>>  "+threadName);
		return executerServiceManager;
	}

}
