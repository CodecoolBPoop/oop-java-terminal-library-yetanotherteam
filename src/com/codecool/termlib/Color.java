package com.codecool.termlib;

public enum Color {
    BLACK ("30", "40"),
    RED("31","41"),
    GREEN("32","42"),
    YELLOW("33","43"),
    BLUE("34","44"),
    MAGENTA("35","45"),
    CYAN("36","47"),
    WHITE("37","47");

    private final String foreground;
    private final String background;			

    Color(String foreground,String background){
		this.foreground = foreground;
		this.background = background;	
	}
    public String foreground(){return foreground;}
    public String background(){return background;}		
	
}
