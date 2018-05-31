package com.codecool.termlib;

import com.codecool.termlib.*;
import java.lang.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

import com.codecool.termlib.Game;

public class Main{

	public Main(){

	}

	public void playGame() {		
		Terminal newTerminal = new Terminal();
		Game game = new Game();

		newTerminal.setColor(Color.BLUE);
				
		String[] words = game.dictionary; //ez ide felesleges, de sajna nem tudok megszabadulni mert így lett megírva, ez inicializálja a szólistát a game.java-ban		
		ArrayList<Word> currentWords = new ArrayList<Word>();	//inicializálom az arraylistet amiben word instanceket fogok tárolni	
		
		String input = ""; //String object, ide gyűjtöm a beírt karaktereket, enter leütésre megtörténik az ellenőrzés, lásd lentebb
		
		newTerminal.moveTo(24,0); //cursor bal alsó sarokba áll
		newTerminal.setup(); //terminal 'raw' módba állítása, nem szükséges enter a szövegbevitelhez
		int starttime = (int)System.currentTimeMillis(); //kezdeti viszonyítás pont az időben
		int count = 0;	// számolja, hogy hányszor megy lejjebb
		
		Character inputchar; // Character osztály ami felfog minden egyes leütött karaktert, ellenőrzés után appendelődik az input változóhoz	
		
		
		while(count<24){
			
			int currentTime = (int)System.currentTimeMillis(); //időmérés, most épp ennyi az idő
			inputchar = newTerminal.tryToRead(); //kiolvas egy karaktert a user leütéseit tartalmazó standard inputból, csak karakterenként lehetséges
			if(inputchar != null){ //ha 'null', ignorálja
				if(inputchar == '\n'){ // ha enter, megtörténik az eddig leütött karakterek összehasonlítása az aktuális szó listával
					int testresult = game.checkInput(currentWords,input); 
					//ellenőrzés, egyezés esetén a szó indexét adja vissza, egyébként-1					
					if(testresult > -1){
						currentWords.remove(testresult); //ha nem -1, index alapján törli a listából
					}
					input = "";//kiűríti az inputot
				}
				else{input += inputchar;}// ha nem enter, a leütött karaktert appendeli az input változóhoz				
			
			}
			if(currentTime - starttime > 1000){ //ha a viszonyítási ponthoz képest a currenttime 1000 ms-el több, megtörténik a screenfrissítés
				currentWords.add(game.getNewWord());
				//minden frissítéskor a szólista kap egy új szót (Word osztály)									
				newTerminal.saveCursor();//elindul a cursor mozgatása (for loop lentebb), elmenti a kezdeti állást, hogy vissza tudjon állni
				newTerminal.clearScreen();//screen törlés
				for(int k = 0; k<currentWords.size(); k++){ //átiterál a szólistán
					String currentWord = currentWords.get(k).getWord(); //aktuális szó lekérése
					int yCoord = currentWords.get(k).getY(); //akutális szó y koordinátájának lekérése
					int xCoord = currentWords.get(k).getX(); //akutális szó x koordinátájának lekérése
					if(yCoord>0){
						newTerminal.setWord(currentWord,yCoord,xCoord); //aktuális szó kiírása a lekért adatok alapján
					}
					currentWords.get(k).setY(yCoord+1); //aktuális szó y koordinátájának inkrementálása, hisz most már eggyel lejjebb van
				}				
				starttime = (int)System.currentTimeMillis();//új viszonyítási pont, elmenti az utolsó frissítés idejét, most már ehhez méri az 1000ms-t
				newTerminal.restoreCursor(); //cursor visszaáll az elmentett helyére, lsd. fejjebb
				count++;//frissítés számláló
			}
		
		}
	}
	
	public static void main(String[] args){
		Menu gameMenu = new Menu();
		gameMenu.menuOptions();
	}

}
