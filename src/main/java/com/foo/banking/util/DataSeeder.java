package com.foo.banking.util;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dataSeeder")
@Component
public class DataSeeder 
{
	@PostConstruct
	public void run() 
	{
	}
}

