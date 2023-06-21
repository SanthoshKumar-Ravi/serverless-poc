package com.bsdv.poc.serverless;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionalSpringApplication;

@SpringBootApplication
public class FileUploadFunctionApplication {

	public static void main(String[] args) {
		FunctionalSpringApplication.run(FileUploadFunctionApplication.class, args);
	}

}
