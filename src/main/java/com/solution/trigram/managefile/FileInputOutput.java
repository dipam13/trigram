package com.solution.trigram.managefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputOutput {
	
	private final List<String> inputText;
	
	public FileInputOutput() {
		this.inputText = new ArrayList<>();
	}

	public List<String> getInputText() {
		return inputText;
	}
	
	/*
	 * Input parameter is File Name
	 * 
	 * Get file from the folder and read text from file. 
	 * 
	 */
	public void inputFile(File file) {
		
		try {
			if(file.exists() && file.length() > 0) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String str;

				while((str = br.readLine()) != null) {
					this.inputText.add(str);
				}
				br.close();
				
			} else if(file.length() <= 0) {
				System.out.println("There is no content in the file.");
			} else {
				System.out.println("File not exist!");
			}
			
		} catch (IOException e) {
			System.out.println("Error in file.");
		}
	}

	/*
	 * Input parameter is result string
	 * 
	 * Check file is exist in directory or not?
	 * 	- delete file if exist
	 * create a new output.txt file in directory
	 * 
	 * Write result string into output.txt file
	 */
	
	public void getOutputFile(String text) throws IOException {
		String fname = "InputFiles/output.txt";
		File file = new File(fname);
		boolean created;
		
		try {
			if(file.exists()) {
				file.delete();
				System.out.println("File deleted.");
			}
			
			created = file.createNewFile();
			if(created) {
				System.out.println("File Created.");
			}
			
			FileOutputStream output = new FileOutputStream(fname, true);
			String str = text;
			byte[] b = str.getBytes();
			output.write(b);
			output.close();
			System.out.println("Saved...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
