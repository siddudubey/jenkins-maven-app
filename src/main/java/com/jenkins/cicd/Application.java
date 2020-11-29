package com.jenkins.cicd;

public class Application {

	public static void main(String[] args) {
		System.out.println(new Application().getMessage());
	}

	private final String message = "The application has started.";

	private String getMessage() {
		
		return message ;
	}

}
