import java.util.Scanner;

public class IrfanFilipovicAssignment1 {
	
	public static void main(String[] args ) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		int sum = 0;
		
		while(flag) {
			System.out.println("Enter p to print, r to reset, q to quit, and i to add an integer:");
			String sym = scanner.next();
			
			if(sym.equals("i")) {
				System.out.println("Enter the integer:");
				int x = scanner.nextInt();
				sum += x;
			}
			
			if(sym.equals("r")) {
				sum = 0;
				System.out.println("sum: " + sum);	
			}
			
			if(sym.equals("p")) {
				System.out.println("sum: " + sum);
			}
			
			if(sym.equals("q")) {
				System.out.println("sum: " + sum);
				flag = false;
			}
		}
	}
}