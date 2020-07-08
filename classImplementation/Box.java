class Box extends Rectangle {
	private double length, width, height;
	
	public Box(double l, double w, double h) {
		super(l, w);
		length = l;
		width = w;
		height = h;
	}

	public double getArea(){ 
		return 2*(length * width) + 2*(width * height) + 2*(height * length);
	}

}