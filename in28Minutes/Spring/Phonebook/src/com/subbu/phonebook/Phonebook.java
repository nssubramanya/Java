/**
 * @author subramanyans
 * @
 */

package com.subbu.phonebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Phonebook {
	ArrayList<PhonebookEntry> entries;
	
	public Phonebook() {
		this.entries = new ArrayList<PhonebookEntry>();
	}
	
	
	public ArrayList<PhonebookEntry> getEntries() {
		return entries;
	}
	
	public PhonebookEntry addEntry(String name, String number) {
		if (name == null || name.length()==0)
			throw new IllegalArgumentException("Invalid Arguments");
		
		if (!doesNameExist(name)) {
			PhonebookEntry entry = new PhonebookEntry(name, number);
			entries.add(entry);
			return entry;
		} else {
			return null;
		}
	}
	
	public void addEntry(PhonebookEntry entry) {
		entries.add(entry);
	}
	
	private Boolean doesNameExist(String name) {
		for (PhonebookEntry entry : entries) {
			if (entry.getName().contains(name)) {
				return true;
			}	
		}
		return false;
	}
	
	public Boolean deleteEntry(String name) {
		for (PhonebookEntry entry : entries) {
			if(entry.getName().contains(name)) {
				entries.remove(entry);
				return true;
			}
		}
		
		return false;
	}
	
	public ArrayList<PhonebookEntry> search (String nameOrNumber){
		
		Set<PhonebookEntry> result = new HashSet<PhonebookEntry>();
		
		for (PhonebookEntry entry : entries) {
			if(entry.getName().contains(nameOrNumber))
				result.add(entry);
			for(String number : entry.getNumbers()) {
				if(number != null && number.contains(nameOrNumber))
					result.add(entry);
			}
		}
		return(new ArrayList<PhonebookEntry>(result));
	}
	
	public void PrintPhonebook() {
		System.out.println("Phonebook:");
		for (PhonebookEntry phonebookEntry : entries) {
			System.out.println(phonebookEntry.toString());
		}
	}

	public static void main(String[] args) {

		Phonebook pb = new Phonebook();
		
		PhonebookEntry pbe = pb.addEntry("Subbu","8861018585");
		pbe.addNumber("9243495509");
		pb.addEntry("Roopa", "9845964378");
		pb.addEntry("Subhash","8123412675");
		pb.addEntry("Sushruth", null);
		pb.PrintPhonebook();
		
		ArrayList<PhonebookEntry> matches = pb.search("37");
		System.out.println(matches);
		
		pb.deleteEntry("Roopa");
		pb.PrintPhonebook();
		
//		List<String> matches = pbe.getNumbers()
//									.stream()
//									.filter(it -> it.contains("5"))
//									.collect(Collectors.toList());
//		System.out.println(matches);
	}
}