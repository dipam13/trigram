package com.solution.trigram.example;

import java.io.File;
import java.io.IOException;

import com.solution.trigram.managefile.FileInputOutput;
import com.solution.trigram.managetext.GenerateString;

public class TrigramSolution {
	
	/*
	 * main file to run 
	 */
	public static void main(String[] args) throws IOException {

		FileInputOutput fio = new FileInputOutput();
		GenerateString generateString = new GenerateString();
		
		String fileName = "InputFiles/codekata.txt";
		File file = new File(fileName);
		fio.inputFile(file);
		
		generateString.getMapOfKeyValue(fio.getInputText());
		
		generateString.getTextFromMap(generateString.getTextToMap(), file.length());
		
		fio.getOutputFile(generateString.getResultText());
	}	
	
}
