package fiero;

import java.io.*;
import java.util.*;

public class CleanFile {
	static final int MAX_LENGTH = 11;
	static final int MIN_LENGTH = 8;
	
	public void cleanAndPrintAfterSlash(String input_file, String output_file) throws IOException {
		// file input
        File fin = new File(input_file);
        // file output
        FileWriter fout = new FileWriter(output_file);
        // oggetto reader con codifica dei caratteri UTF-16
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fin), "UTF-16"));
        // oggetto writer
        BufferedWriter writer = new BufferedWriter(fout);
        // stringa per leggere ogni riga del file
        String line;
        // ArrayList per rimuovere tutte le parole dopo '/'
        ArrayList<String> words = new ArrayList<>();
        // Array finale da stampare su file
        String[] finalWords;
        
        while ((line = reader.readLine()) != null) {
            if ((line.charAt(0) >= 'a' && line.charAt(0) <= 'z') ||
                    (line.charAt(0) >= 'A' && line.charAt(0) <= 'Z'))
                words.add(line);
        }
        // inserisco i caratteri nell'array e stampo
        for (String element : words) {
            finalWords = element.split("/");
            writer.write(finalWords[0] + "\n");
        }
        reader.close();
        writer.close();
	}
	
	public int wordsBetweenEightAndEleven(String input_file) throws IOException {
		// file input
        File fin = new File(input_file);
        // oggetto reader con codifica dei caratteri UTF-16
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fin), "UTF-16"));
        // stringa per leggere ogni riga del file
        String line;
        // ArrayList per rimuovere tutte le parole dopo '/'
        ArrayList<String> words = new ArrayList<>();
        // Array finale da stampare su file
        String[] finalWords;
        
        while ((line = reader.readLine()) != null) {
            if ((line.charAt(0) >= 'a' && line.charAt(0) <= 'z') ||
                    (line.charAt(0) >= 'A' && line.charAt(0) <= 'Z'))
                words.add(line);
        }
        int counter = 0;
        // controllo la lunghezza della parola
        for (String element : words) {
            finalWords = element.split("/");
            if (finalWords[0].length() <= MAX_LENGTH && finalWords[0].length() >= MIN_LENGTH) {
            	counter++;
            }
        }
        reader.close();
        return counter;
	}
	
	// genera anagrammi
	public ArrayList<String> anagram(String s) {
		ArrayList<String> finalArrayList = new ArrayList<>();
		if (s.length() <= 1)
			finalArrayList.add(s);
		else {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				ArrayList<String> temp = anagram(s.substring(0, i) + s.substring(i + 1));
				for (String element : temp) {
					finalArrayList.add(c + element);
				}
			}
		}
		return finalArrayList;
	}
	
	// numero anagrammi contenuti nel file
	public int numbersOfAnagrams(String input_file, String word) throws IOException {
		ArrayList<String> anagrams = anagram(word);
		int counter = 0;
		// file input
        TextFile file = new TextFile(input_file, 'r');
		// stringa per leggere ogni riga del file
        String line;
		while((line = file.fromFile()) != null) {
			for (String element : anagrams) {
				if (line.equalsIgnoreCase(element))
					counter++;
			}
		}
		file.close();
		return counter;
	}
	
}