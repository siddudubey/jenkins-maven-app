package com.jenkins.cicd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ApplicationTest {
	
	private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outputContent));
	}
	
	@Ignore
	public void testStream() {
		Application.main(null);
		try {
			assertEquals(outputContent.size(), outputContent.toByteArray().length);
		}catch (AssertionError e) {
			fail("Output stream is corrupted.");
		}
	}
	
	@Test
	public void testApplicationMain() {
		Application.main(null);
		try {
			assertEquals("The application has started.\r\n", outputContent.toString());
		}catch (AssertionError e) {
			fail("\"message\" is not \"The application has started.\"");
		}
	}

	@Test
	public void testApplicationConstructor() {
		try {
			new Application();
		}catch (Exception e) {
			fail("constructor failed!");
		}
	}
	
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

}
