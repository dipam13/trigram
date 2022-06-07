package com.solution.trigram.managetext;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class GenerateStringTest {
	
	GenerateString generateString = new GenerateString();
	
	@SuppressWarnings("serial")
	@Test
	void generateMap() {
		List<String> inputText = Arrays.asList("I wish I may I wish I might");
		Map<String, List<String>> expected = new HashMap<>();
		expected.put("i wish", new ArrayList<>() {{add("i"); add("i"); }});
		expected.put("wish i", new ArrayList<>() {{add("may"); add("might"); }});
		expected.put("may i", new ArrayList<>() {{add("wish"); }});
		expected.put("i may", new ArrayList<>() {{add("i"); }});
		
		generateString.getMapOfKeyValue(inputText);
		
		Map<String, List<String>> actualText = generateString.getTextToMap();
		
		assertEquals(expected, actualText);
		
	}
	
	@SuppressWarnings("serial")
	@Test
	void generateWithMultipleLines() {
		List<String> inputText = Arrays.asList("I wish I may I wish I might", "Wish I might go");
		Map<String, List<String>> expected = new HashMap<>();
		expected.put("i wish", new ArrayList<>() {{add("i"); add("i"); }});
		expected.put("may i", new ArrayList<>() {{add("wish"); }});
		expected.put("i may", new ArrayList<>() {{add("i"); }});
		expected.put("i might", new ArrayList<>() {{add("go"); }});
		expected.put("wish i", new ArrayList<>() {{add("may"); add("might"); add("might");}});
				
		generateString.getMapOfKeyValue(inputText);
		
		Map<String, List<String>> actualText = generateString.getTextToMap();
		
		assertEquals(expected, actualText);
	}

}
