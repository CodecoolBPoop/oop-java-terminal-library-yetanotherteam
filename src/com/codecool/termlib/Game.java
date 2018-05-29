package com.codecool.termlib;

import java.util.Arrays;
import java.io.File;

public class Game {

	public String[] dictonary = readFiles();

	private String[] readFiles() {
		String[] words = new String[0];
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		while ((line = file.readLine()) != null) {
			saveWords = Arrays.copyOf(words, words.length+1);
   			words = new String[words.length+1];
   			words = saveWords;
   			words[words.length+1] = line;
			 }

		return words;


	}

}

