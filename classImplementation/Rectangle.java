class Rectangle implements Measurable {
	private double length, width;
	
	public Rectangle(double sideLength, double sideWidth) {
		length = sideLength;
		width = sideWidth;
	}

	public double getArea(){
		return length * width;
	}
}