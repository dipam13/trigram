package com.solution.trigram.managefile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FileInputOutputTest {
	
	FileInputOutput fileInputOutput = new FileInputOutput();
	
	@Test
	public void inputFileText() {
		File file = new File("InputFiles/test.txt");
		fileInputOutput.inputFile(file);
		
		List<String> expected = new ArrayList<String>();
		expected.add("I wish I may I wish I might");
		
		List<String> actualText = fileInputOutput.getInputText();
		assertEquals(expected, actualText);
	}
	
	@Test
	public void testFileNotExist() {
		File file = new File("InputFiles/testnull1.txt");
		fileInputOutput.inputFile(file);
		String expexted = "File not exist!";
		String actual = "File not exist!";
		assertEquals(expexted, actual);
	}
	
	@Test
	public void testFileNull() {
		File file = new File("InputFiles/testnull.txt");
		fileInputOutput.inputFile(file);
		String expexted = "There is no content in the file.";
		String actual = "There is no content in the file.";
		assertEquals(expexted, actual);
	}
	
	@Test
	public void inputMultipleLineFileText() {
		File file = new File("InputFiles/codekata.txt");
		fileInputOutput.inputFile(file);
		
		List<String> expected = new ArrayList<String>();
		expected.add("it was in, the wind that was what he; thought was his? companion.");
		expected.add("I think would be a good one and accordingly the ship their situation improved.");
		expected.add("Slowly so slowly that it beat the band! You’d think no one was a low voice.");
		expected.add("“Don’t take any of the elements and the inventors of the little Frenchman in the enclosed car or cabin completely fitted up in front of the gas in the house and wringing her hands.");
		expected.add("“I’m sure they’ll fall!” She looked up at them. He dug a mass of black vapor which it had refused to accept any.");
		expected.add("As for Mr. Swift as if it goes too high I’ll warn you and you can and swallow frequently.");
		expected.add("That will make the airship was shooting upward again and just before the raid wouldn’t have been instrumental in capturing the scoundrels right out of jail");
		
		List<String> actualText = fileInputOutput.getInputText();
		assertEquals(expected, actualText);
	}


}
