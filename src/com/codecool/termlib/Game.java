package com.codecool.termlib;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.codecool.termlib.Word;


public class Game {

	public String[] dictionary = readWords();

	private String[] readWords() {
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

	
	
	public Word getNewWord(){
		Word word0 = new Word(ThreadLocalRandom.current().nextInt(0,70),0,dictionary[ThreadLocalRandom.current().nextInt(0,10000)]);
		return word0;
		//vissza ad egy új Word instancet egy random szóval, random x, y = 0 pozícióval
		
	}
	
	public int checkInput(ArrayList<Word> currentWords, String input){
		for(int i = 0; i < currentWords.size();i++){
			String wort = currentWords.get(i).getWord();				
			if(Objects.equals(wort,input)){return i;}			
			
		}
		return -1;
		//megkapja a word listet és az inputot az enter leütésére, átiterál a szólistán, minden szót összehasonlít az inputtal, ha talál egyezést, az indexet return, ha nincs egyezés, -1-et	
	}

	
}

