package com.data.bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RuntimeBean {
	
	
	public static double calculateAverage(double[] changes) {
	    if (changes == null || changes.length == 0) {
	        throw new IllegalArgumentException("Array cannot be null or empty");
	    }

	    double sum = 0.0;
	    for (double change : changes) {
	        sum += change;
	    }

	    return sum / changes.length;
	}


}
