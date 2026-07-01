package org.demo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Sample {

	public static void main(String[] args) {

		// asMaps() -> 2d with header[keys]
		// 1st string -> key or header
		// 2nd string -> value or data

		// row column
		List<LinkedHashMap<String, String>> l = new ArrayList<LinkedHashMap<String, String>>();

		LinkedHashMap<String, String> m = new LinkedHashMap<>();
		m.put("id", "101");
		m.put("name", "abu");
		m.put("email", "abu@gmail.com");

		LinkedHashMap<String, String> m1 = new LinkedHashMap<>();
		m1.put("id", "102");
		m1.put("name", "mani");
		m1.put("email", "mani@gmail.com");

		l.add(m);
		l.add(m1);
		System.out.println(l);

		LinkedHashMap<String, String> l1 = l.get(1);
		System.out.println(l1);

		System.out.println(l1.get("id"));
		System.out.println(l1.get("name"));
		System.out.println(l1.get("email"));

	}

}
