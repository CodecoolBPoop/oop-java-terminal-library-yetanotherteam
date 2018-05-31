package com.codecool.termlib;

import com.codecool.termlib.Direction;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.lang.*;
import java.io.IOException;

public class Terminal {
    /**
     * The beginning of control sequences.
     */
    private static final String CONTROL_CODE = "\033[";
    /**
     * Command for whole screen clearing.
     *
     * Might be partitioned if needed.
     */
    private static final String CLEAR = "2J";
    /**
     * Command for moving the cursor.
     */
    private static final String MOVE = "H";
    /**
     * Command for printing style settings.
     *
     * Handles foreground color, background color, and any other
     * styles, for example color brightness, or underlines.
     */
    private static final String STYLE = "m";

    /**
     * Reset printing rules in effect to terminal defaults.
     *
     * Reset the color, background color, and any other style
     * (i.e.: underlined, dim, bright) to the terminal defaults.
     */
    public void resetStyle() {
        String resetAll = String.format("0%s", STYLE);
        command(resetAll);
    }

    /**
     * Clear the whole screen.
     *
     * Might reset cursor position.
     */
    public void clearScreen() {

       /* String clearScr = CLEAR + CONTROL_CODE + MOVE;  // "\033c" for really resetting the terminal
        command(clearScr);*/
	
	moveTo(24,0);
	
	for(int i = 0; i<24;i++){
		moveCursor(Direction.UP, 1);
		command("2K");
	}
	
	moveTo(24,0);

    }

    /**
     * Move cursor to the given position.
     *
     * Positions are counted from one.  Cursor position 1,1 is at
     * the top left corner of the screen.
     *
     * @param x Column number.
     * @param y Row number.
     */
    public void moveTo(Integer x, Integer y) {
        String moveTo = String.format("%d;%d%s", x,y,MOVE);
        command(moveTo);
    }

    /**
     * Set the foreground printing color.
     *
     * Already printed text is not affected.
     *
     * @param color The color to set.
     */
    public void setColor(Color color) {
	String settextcolor = color.foreground() + STYLE;
	command(settextcolor);
    }
    
    /**
     * Set the background printing color.
     *
     * Already printed text is not affected.
     *
     * @param color The background color to set.
     */
    public void setBgColor(Color color) {
	String setbgcolor = color.background() + STYLE;
	command(setbgcolor);
    }

    /**
     * Make printed text underlined.
     *
     * On some terminals this might produce slanted text instead of
     * underlined.  Cannot be turned off without turning off colors as
     * well.
     */
    public void setUnderline() {
    }

    /**
     * Move the cursor relatively.
     *
     * Move the cursor amount from its current position in the given
     * direction.
     *
     * @param direction Step the cursor in this direction.
     * @param amount Step the cursor this many times.
     */
    public void moveCursor(Direction direction, Integer amount) {
        String moveCursor = "";

        switch(direction) {
            case UP:
                moveCursor += amount+"A";
            break;
            case DOWN:
                moveCursor += amount+"B";
            break;
            case FORWARD:
                moveCursor += amount+"C";  
            break;
            case BACKWARD:
                moveCursor += amount+"D";
            break;          
        }

        command(moveCursor);
    }

    /**
     * Set the character diplayed under the current cursor position.
     *
     * The actual cursor position after calling this method is the
     * same as beforehand.  This method is useful for drawing shapes
     * (for example frame borders) with cursor movement.
     *
     * @param c the literal character to set for the current cursor
     * position.
     */
    public void setWord(String word, int x, int y) {
	
	
	moveTo(x,y);
	System.out.print(word);
	
    }

    /**
     * Helper function for sending commands to the terminal.
     *
     * The common parts of different commands shall be assembled here.
     * The actual printing shall be handled from this command.
     *
     * @param commandString The unique part of a command sequence.
     */
    private void command(String commandString) {		
	System.out.printf("%s%s", CONTROL_CODE, commandString);
    }

    


   public void saveCursor(){
	command("s");	
	}


   public void restoreCursor(){
	command("u");
}	

   public void setup(){
	try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("stty raw -echo");
	}catch(Exception e){
		e.printStackTrace();	
	}

		
}
   public Character tryToRead() {
    try {
        if (System.in.available() > 0) {	    

	    char input = (char)System.in.read();	


            return input;
        }
    }
    catch (IOException e) {
        System.err.println("Error " + e.getMessage());
    }
    return null;
}	
}
