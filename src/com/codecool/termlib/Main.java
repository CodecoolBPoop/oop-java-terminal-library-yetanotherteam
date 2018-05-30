import com.codecool.termlib.Terminal;
import com.codecool.termlib.Color;
import com.codecool.termlib.Game;

public class Main{
	
	public static void main(String[] args){
		// Terminal newTerminal = new Terminal();
		// newTerminal.setBgColor(Color.RED);

		// newTerminal.setColor(Color.BLUE);
		// System.out.println("testline");
		

		// System.out.println("Hello World");
		// newTerminal.resetStyle();
		// System.out.println("Hello World");
		// newTerminal.clearScreen();

		Game game = new Game();
		String[] words = game.dictonary;

		for(int i = 0; i < words.length; i++) {
			System.out.println(words[i]);

		}

 
	}

}
