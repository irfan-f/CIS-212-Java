class Sphere extends Circle {
	private double radius;
	
	public Sphere(double r) {
		super(r);
		radius = r;
	}

	public double getArea(){ 
		return 4 * Math.PI * radius * radius;
	}

}