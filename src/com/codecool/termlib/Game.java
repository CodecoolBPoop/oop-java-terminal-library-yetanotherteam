package com.codecool.termlib;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {

	public String[] dictonary = readFiles();

	private String[] readFiles() {
		String[] words = new String[0];

		  try (BufferedReader br = new BufferedReader(new FileReader("dictonary.txt"))) {

			String line;
			while ((line = br.readLine()) != null) {
				words = Arrays.copyOf(words, words.length+1);
				words[words.length-1] = line;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return words;


	}

}

