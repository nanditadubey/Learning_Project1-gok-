package com.gojek.comparator;

import java.util.Comparator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class JsonComparator implements Comparator<JsonNode>{

	public int compare(JsonNode o1, JsonNode o2) {
		if(o1.equals(o2)) {
		return 0;
		}
		 if ((o1 instanceof TextNode) && (o2 instanceof TextNode)) {
	            String s1 = ((TextNode) o1).asText();
	            String s2 = ((TextNode) o2).asText();
	            if (s1.equalsIgnoreCase(s2)) {
	                return 0;
	            }
	        }

		Integer x = compareNumericValue(o1, o2);
		if (x != null) return x;
		return 1;
	    
	}
 //checks if Numeric value . 5.0 and 5 Makes  same and return0
	private Integer compareNumericValue(JsonNode o1, JsonNode o2) {
		if ((o1 instanceof NumericNode) && (o2 instanceof NumericNode)){
			Double d1 = ((NumericNode) o1).asDouble();
			Double d2 = ((NumericNode) o2).asDouble();
			if (d1.compareTo(d2) == 0) {
				return 0;
			}
		}else {
			return 1;
		}
		return null;
	}

}
