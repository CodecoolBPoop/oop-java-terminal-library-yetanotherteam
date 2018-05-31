package com.codecool.termlib;

import com.codecool.termlib.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

	public int getRulesNumber() {

		printRules();
		int rulesNumber = 100;
        boolean invalidInteger = true;

        do {
            Scanner scanMenuNumber = new Scanner(System.in);
            try {
	            rulesNumber = scanMenuNumber.nextInt();
            	if (rulesNumber == 0) {
            		invalidInteger = false;
            	} else {
            		invalidInteger = true;
            	}
            	
            } catch(InputMismatchException inputError) {
                System.out.println("The character you entered is not an integer.");
                System.out.println(inputError);
                invalidInteger = true;
            } finally {
				printRules();
			}
        } while (invalidInteger);
        return rulesNumber;

	}

	public void printRules() {
		Terminal menuTerminal = new Terminal();
		String blankPadding = " ";
		for (int i = 0; i < 25; i++) {
			if (i > 9 && i < 16) {
				String leftMargin = "          ";
				String menuName;
				switch (i) {
					case 10: menuName = "Type in the falling words and hit enter.";
					break;
					case 11: menuName = "You get as many points for getting a word right as";
					break;
					case 12: menuName = "the number of characters contained in the word.";
					break;
					case 13: menuName = "Fail to type a word correcty and you will lose one life.";
					break;
					case 14: menuName = "You have only 5 lives. Good luck.";
					break;
					case 15: menuName = "Press 0 to go back to main menu";
					break;
					default: menuName = "";
					break;
				}

				menuTerminal.setBgColor(Color.GREEN);
				System.out.print(leftMargin);
				menuTerminal.setColor(Color.WHITE);
				int paddingLength = 80 - leftMargin.length();
				String paddingString = new String("");
				System.out.printf("%1$-" + paddingLength + "s", menuName);
				menuTerminal.resetStyle();
				System.out.println();				
			} else {
				menuTerminal.setBgColor(Color.GREEN);
				System.out.printf("%1$-" + 80 + "s", blankPadding);
				menuTerminal.resetStyle();
				System.out.println();
			}
		}
	}

	public void printBoard() {
		Terminal menuTerminal = new Terminal();
		String blankPadding = " ";
		for (int i = 0; i < 25; i++) {
			if (i > 9 && i < 15) {
				String leftMargin = "          ";
				String menuName;
				switch (i) {
					case 10: menuName = "1. Play Game";
					break;
					case 11: menuName = "2. Choose level";
					break;
					case 12: menuName = "3. Rules";
					break;
					case 13: menuName = "4. High Scores";
					break;
					case 14: menuName = "0. Quit Game";
					break;
					default: menuName = "Key error";
					break;
				}

				menuTerminal.setBgColor(Color.GREEN);
				System.out.print(leftMargin);
				menuTerminal.setColor(Color.WHITE);
				int paddingLength = 80 - leftMargin.length();
				String paddingString = new String("");
				System.out.printf("%1$-" + paddingLength + "s", menuName);
				menuTerminal.resetStyle();
				System.out.println();				
			} else {
				menuTerminal.setBgColor(Color.GREEN);
				System.out.printf("%1$-" + 80 + "s", blankPadding);
				menuTerminal.resetStyle();
				System.out.println();
			}
		}
	}

	public int getMenuNumber(int maximum) {
		printBoard();
		int menuNumber = 100;
        boolean invalidInteger = true;

        do {

            Scanner scanMenuNumber = new Scanner(System.in);

            try {
	            menuNumber = scanMenuNumber.nextInt();
            	if (menuNumber >= 0 && menuNumber <= maximum) {
            		invalidInteger = false;
            	} else {
            		invalidInteger = true;
            	}
            	
            } catch(InputMismatchException inputError) {
                System.out.println("The character you entered is not an integer.");
                System.out.println(inputError);
                invalidInteger = true;
            } finally {
				printBoard();
			}
        } while (invalidInteger);
        return menuNumber;
	}

	public void menuOptions() {
		Main startMain = new Main();
		options:
			do {
				int chosenNumber = getMenuNumber(4);
				switch (chosenNumber) {
					case 1: startMain.playGame();
							break;
					case 2: System.out.println("Choose level");
							break;
					case 3: getRulesNumber();
							break;
					case 4: System.out.println("High scores");
							break;
					case 0: System.out.println("You quitted the game");
							break options;
					default: System.out.println("Key error");
							break;
				}
			} while (true);
	}

}