import com.codecool.termlib.Terminal;
import com.codecool.termlib.Color;

public class Main{
	
	public static void main(String[] args){
		Terminal newTerminal = new Terminal();
		newTerminal.setBgColor(Color.RED);
		System.out.println("Hello World");
		newTerminal.resetStyle();
		System.out.println("Hello World");
		newTerminal.clearScreen();
	}

}
