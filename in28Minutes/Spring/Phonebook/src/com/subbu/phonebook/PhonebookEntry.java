package com.subbu.phonebook;

import java.util.ArrayList;

public class PhonebookEntry {
	private String name;
	private ArrayList<String> numbers = new ArrayList<String>();
	
	
	public PhonebookEntry(String name, String number) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.numbers.add(number);
	}
	
	public PhonebookEntry(String name, ArrayList<String> numbers) {
		this.name = name;
		this.numbers = numbers;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getNumbers() {
		return numbers;
	}
	public void addNumber(String number) {
		numbers.add(number);
	}
	
	public void deleteNumber(String number) {
		numbers.remove(number);
	}

	@Override
	public String toString() {
		return name + ": " + numbers.toString();
	}
}
