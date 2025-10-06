package DescisionMaking;

import java.util.*;

/*
 * 
You are given two integers n and m. You must return:

"lesser" if n < m

"equal" if n == m

"greater" if n > m

Constraints:
-10^9 <= n, m <= 10^9


Solutions 
If-Else → Beginner, clear.

Ternary Operator → Concise, one-liner.

Switch Expression (Java 14–21) → Modern and elegant.

Comparator Functional Approach → Uses Java functional programming style.

Streams + Map → More abstract, extensible.

Pattern Matching + Records (Java 21) → Latest Java 21 style, clean & powerful.

*/

public class CompareTwoValues {

	public static void main(String[] args) {
		System.out.println("Approach 1: Basic If-Else (Beginner-Friendly) --->>>" + compareValues1(10, 20));
		System.out.println("Approach 2: Ternary Operator (Compact Form) --->>>" + compareValues2(10, 20));
		System.out.println("Approach 3: Switch Expression (Java 14+, fully standardized in Java 21) --->>>"
				+ compareValues3(10, 20));
		System.out.println("Approach 4: Comparator Functional Approach --->>>" + compareValues4(10, 20));
		System.out.println("Approach 5: Java Streams & Map (Overkill but Advanced) --->>>" + compareValues5(10, 20));

	}

	public static String compareValues1(int n, int m) {
		if (n < m) {
			return "lesser";
		} else if (n == m) {
			return "equals";
		} else {
			return "greater";
		}
	}

	public static String compareValues2(int n, int m) {
		return (n < m) ? "lesser" : (n == m) ? "equals" : "greater";
		// return (n<m) ? "lesser" : (n==m) ?"equals" : (n>m) ? "greater" : "";
	}

	public static String compareValues3(int n, int m) {
		return switch (Integer.compare(n, m)) {
		case -1 -> "lesser";
		case 0 -> "equals";
		case 1 -> "greater";
		default -> throw new IllegalStateException("Unexpected Value: " + Integer.compare(n, m));
		};
	}

	public static String compareValues4(int n, int m) {
		int result = Comparator.<Integer>naturalOrder().compare(n, m);
		return (result < 0) ? "lesser" : (result == 0) ? "equal" : "greater";
	}

	private static final Map<Integer, String> resultMap = Map.of(-1, "lesser", 0, "equal", 1, "greater");

	public static String compareValues5(int n, int m) {
		return resultMap.get(Integer.compare(n, m));
	}
}
