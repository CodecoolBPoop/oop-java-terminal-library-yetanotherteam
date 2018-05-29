import com.codecool.termlib.Terminal;
import com.codecool.termlib.Color;
import com.codecool.termlib.Word;
import java.lang.*;
import java.util.Scanner;
import java.io.IOException;

public class Main{
	
	public static void main(String[] args){
		Terminal newTerminal = new Terminal();
		

		newTerminal.setColor(Color.BLUE);
		
		String inputchar = "";
		
		newTerminal.moveTo(24,0);
		newTerminal.setup();
		int starttime = (int)System.currentTimeMillis();
		int count = 0;
		
		
		while(true){
			newTerminal.saveCursor();
			int currentTime = (int)System.currentTimeMillis();
			if(currentTime - starttime > 1000){
				count++;
				newTerminal.clearScreen();
				newTerminal.setWord("szó",0+count,24);
				newTerminal.moveTo(24,0);
				starttime = (int)System.currentTimeMillis();
			}
			
			newTerminal.restoreCursor();					
		        
			
			
			
		
		
		}
		
		}
		
		

 
	

}
