package edu.school;

public class DominoTile {
	private int left;
	private int right;
	
	public DominoTile(int left, int right) {
		if(left >=0 && left <=6 && right >= 0 && right <= 6) {
			this.left = left;
			this.right = right;
		}
	}
	public DominoTile() {
		this.left = 0;
		this.right = 0;
	}
	
	public int getLeft() {
		return this.left;
	}
	public int getRight() {
		return this.right;
	}
	
	public void setLeft(int left) {
		this.left = left;
	}
	public void setRight(int right) {
		this.right = right;
	}
	
	public void swapValues() {
		int temp = left;
		left = right;
		right = temp;
	}
	public boolean equals(DominoTile anotherDomino) {
		if(getLeft() == anotherDomino.getLeft() && getRight() == anotherDomino.getRight()) {
			return true;
		}
		if(getLeft() == anotherDomino.getRight() && getRight() == anotherDomino.getLeft()) {
			return true;
		}
			return false;
	}
	public String toString() {
		char[][] arrayDomino = new char[3][6];
		String result = "";
		for(int row = 0; row < arrayDomino.length ; row++) {
			for(int col = 0; col < arrayDomino.length; col++) {
				result += arrayDomino[row][col];
			}
		}
		return result;
	}
	

}
