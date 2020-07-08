import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Double;

class Main{
	private static double nextDouble() {
		Random ran = new Random();
		double doub = ran.nextDouble() + Double.MIN_VALUE;
		return doub;
	}
	private static double calculateSum(ArrayList<Measurable> x){
		double sum = 0;
		for(int i = 0;i < x.size(); i++){
			sum = sum + x.get(i).getArea();
		}
		return sum;
	}

	
	public static void main(String[] args) {
		Random num = new Random();
		int n = 0;
		int o = 0;
		int	p = 0;
		int q = 0;
		ArrayList<Measurable> x = new ArrayList<Measurable>(1000); 
		for(int count = 0;count<1000; count++){
			double rando = Main.nextDouble();
			if(rando <= 0.25){
				double w = Main.nextDouble();
				double l = Main.nextDouble();
				Rectangle rec = new Rectangle(w, l);
				x.add(rec);
				n += 1;
			}else if(rando <= 0.50){
				double w = Main.nextDouble();
				double l = Main.nextDouble();
				double h = Main.nextDouble();
				Box b = new Box(w, l, h);
				x.add(b);
				o += 1;
			}else if(rando <= 0.75){
				double r = Main.nextDouble();
				Circle c = new Circle(r);
				x.add(c);
				p += 1;
			}else{
				double r = Main.nextDouble();
				Sphere s = new Sphere(r);
				x.add(s);
				q += 1;
			}
			
			}
			System.out.println("rects: " + n + " boxes: " + o + " circles: " + p + " spheres: " + q);
			double sum = Main.calculateSum(x);
			System.out.println("sum: " + sum);
			} 
}