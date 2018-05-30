import com.codecool.termlib.Terminal;
import com.codecool.termlib.Color;
import com.codecool.termlib.Word;
import java.lang.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class Main{
	
	public static void main(String[] args){
		Terminal newTerminal = new Terminal();
		

		newTerminal.setColor(Color.BLUE);
		
		String input = "";
		
		newTerminal.moveTo(24,0);
		newTerminal.setup();
		int starttime = (int)System.currentTimeMillis();
		int count = 0;	
		int wordcount = 0;
		Character inputchar;	
		String[] inputs = new String[10];
		
		while(count<10){
			
			int currentTime = (int)System.currentTimeMillis();
			inputchar = newTerminal.tryToRead();
			if(inputchar != null){
				if(inputchar == '\n'){inputs[wordcount] = input;input = "";wordcount++;}else{input += inputchar;}				
			
			}
			if(currentTime - starttime > 1000){
				count++;					
				newTerminal.saveCursor();
				newTerminal.clearScreen();
				newTerminal.setWord("szó",0+count,24);
				newTerminal.moveTo(24,0);
				starttime = (int)System.currentTimeMillis();
				newTerminal.restoreCursor();
			}
					
		
		
		}
			System.out.print(Arrays.toString(inputs));
		}
		
		

 
	

}
