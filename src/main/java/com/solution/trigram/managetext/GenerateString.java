package com.solution.trigram.managetext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GenerateString {
	
	
	private final Map<String, List<String>> textToMap;
	private String resultText;
	Random random = new Random();
	
	public GenerateString() {
		this.textToMap = new HashMap<String, List<String>>();
		this.resultText = null;
	}
	
	public Map<String, List<String>> getTextToMap() {
		return textToMap;
	}
	
	public String getResultText() {
		return resultText;
	}

	/*
	 * Input parameter is List of string
	 * 
	 * remove the punctuation marks from text and make them LowerCase
	 * 
	 * Split text into words and store in list
	 * 
	 * check whether word (key) is already exist in map 
	 * 	- then add new values (word)
	 *  - else 
	 *  	- generate new list of values for that key
	 * 
	 */
	public void getMapOfKeyValue(List<String> inputText) {

		for(int i = 0; i < inputText.size(); i++) {

			String str = inputText.get(i).replaceAll("\\p{Punct}", "").toLowerCase();
			List<String> list = new ArrayList<>(Arrays.asList(str.split(" ")));
			
			for(int j = 0; j < list.size() - 2; j++) {
				String keys = list.get(j) + " " + list.get(j+1);
				String values = list.get(j+2);
				
				if(this.textToMap.containsKey(keys)) {
					this.textToMap.get(keys).add(values);
				} else {
					List<String> valueList = new ArrayList<String>();
					valueList.add(values);
					this.textToMap.put(keys, valueList);
				}
			}
		}
		
	}

	/*
	 * Input parameter is map and file size
	 * 
	 * get all key and store in new list 
	 * 
	 * randomly find first key and split it to make them two words
	 * 
	 * find next word by generating random values and last word
	 * add them into list
	 * 
	 * concatenate list of words using string buffer
	 * 
	 * get final result string
	 * 
	 */
	public void getTextFromMap(Map<String, List<String>> str1Map, Long fileSize) {
		
		List<String> textList = new ArrayList<String>();
		List<String> strMapKeys = new ArrayList<String>(this.textToMap.keySet());
		
		String startWord = strMapKeys.get(random.nextInt(this.textToMap.size()));
		
		textList.add(startWord.split(" ")[0]);
		textList.add(startWord.split(" ")[1]);
		
		String word = startWord;
		int lastWord = 1;
		
		while(this.textToMap.containsKey(word) && textList.size() <= fileSize) {
			List<String> nextWordList = this.textToMap.get(word);
			String nextWord = nextWordList.get(random.nextInt(nextWordList.size()));
			textList.add(nextWord);
			lastWord += 1;
			word = textList.get(lastWord-1) + " " + textList.get(lastWord);
		}

		StringBuffer sb = new StringBuffer();
		for (String a : textList) {
			sb.append(a + " ");
		}
		
		this.resultText = sb.substring(0, sb.length() - 1);
	}
	
}
