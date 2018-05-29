package com.codecool.termlib;

public class Word{

	private int x;
	private int y;
	private String word = new String();

	public Word(int x, int y, String word){
		this.x = x;
		this.y = y;
		this.word = word;
	}

	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

	public int getY(){
		return this.y;	
	}
	
	public int getX(){
		return this.x;	
	}
	
	public String getWord(){
		return this.word;
	}


}
