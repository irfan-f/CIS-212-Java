import java.awt.Color;

public class Point {
	
	private int x,y,size;
	private Color color;
	
	public Point(int x, int y, int size, Color color) {		
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}