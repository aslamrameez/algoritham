package org.algoritham;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Java8Programs {
	
	public static void main(String[] args) {
	    Map<String, Integer> budget = new HashMap<>();
	    budget.put("clothes", 120);
	    budget.put("grocery", 150);
	    budget.put("transportation", 100);
	    budget.put("utility", 130);
	    budget.put("rent", 1150);
	    budget.put("miscellneous", 90);
	    
	    sortAsc(budget);
	    sortDesc(budget);
}

	private static void sortAsc(Map<String, Integer> budget) {
		Map<String, Integer> sorted = budget
	            .entrySet()
	            .stream()
	            .sorted(comparingByValue())
	            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                    LinkedHashMap::new));

	    System.out.println(sorted);
	}
	
	private static void sortDesc(Map<String, Integer> budget) {
		Map<String, Integer> sorted = budget
	            .entrySet()
	            .stream()
	            .sorted(Collections.reverseOrder(comparingByValue()))
	            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                    LinkedHashMap::new));

	    System.out.println(sorted);
	}

}
