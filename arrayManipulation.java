//Assistance with Scanner methods from https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
//Assistance with For loops from https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html
//Assistance with Arrays from https://www.tutorialspoint.com/java/java_arrays.htm
//Assistance with .Random from https://www.geeksforgeeks.org/java-util-random-nextint-java/
//More Random help at https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#random--
//More Array help at http://javadevnotes.com/java-print-array-examples
//ArrayList help at https://stackoverflow.com/questions/15285179/two-dimensional-arraylist?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
//Time help at https://www.tutorialspoint.com/java/lang/system_nanotime.htm
//More time help at https://stackoverflow.com/questions/24610473/how-to-get-decimal-result-when-converting-nanosecond-to-millisecond?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class IrfanFilipovicAssignment2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an array length");
		int length = scan.nextInt();
		System.out.println("Enter Density:");
		double density = scan.nextDouble();
		if(length<1) {
			System.out.println("Enter an array length(Positive Int):");
			length = scan.nextInt();
		}
		if((density>1.0) || (density<0.0)) {
			System.out.println("Enter Density(Double between 0.0 and 1.0):");
			density = scan.nextDouble();
		}
		double millis = System.nanoTime()/1000000;
		int[] dense = IrfanFilipovicAssignment2.createDense(length, density);
		millis = System.nanoTime()/1000000 - millis;
		System.out.println("Create dense, length: " + length + " time: " + millis);
		millis = System.nanoTime()/1000000 - millis;
		int[][] changedSparse = IrfanFilipovicAssignment2.changeToSparse(dense);
		millis = System.nanoTime()/1000000 - millis;
		System.out.println("Convert to sparse, length: " + changedSparse.length + " time: " + millis);
		millis = System.nanoTime()/1000000 - millis;
		int[][] sparse = IrfanFilipovicAssignment2.createSparse(length, density);
		millis = System.nanoTime()/1000000 - millis;
		System.out.println("Create sparse, length: " + sparse.length + " time: " + millis);
		millis = System.nanoTime()/1000000 - millis;
		int[] changedDense = IrfanFilipovicAssignment2.changeToDense(sparse, length);
		millis = System.nanoTime()/1000000 - millis;
		System.out.println("Convert to dense, length: " + changedDense.length + " time: " + millis);
		millis = System.nanoTime()/1000000 - millis;
		IrfanFilipovicAssignment2.maxDense(dense);
		millis = System.nanoTime()/1000000 - millis;
		System.out.println("dense find time: " + millis);
		millis = System.nanoTime()/1000000 - millis;
		IrfanFilipovicAssignment2.maxSparse(sparse);
		millis = System.nanoTime()/1000000 - millis;
		System.out.println("sparse find time: " + millis);
		
		/*
		It will take slightly longer for an array that has a higher density to create the full sparse and dense arrays and convert them, but
		when finding the max it takes less time.
		When doing smaller length arrays the time will always be shorter and shorter than long lengths.
		*/
	}
	public static int[] createDense(int length, double density){
		Random random = new Random();
		int [] dense = new int[length];
		for(int count = 0; count<length; count++){
			double prob = random.nextDouble();
			if(density>prob){
				dense[count] = 0;
			} else {
				dense[count] = random.nextInt(1000000) + 1;
			}
		}
		return dense;
	}
	public static int[][] createSparse(int length, double density){
		Random random = new Random();
		int[] hold = new int[length];
		int range = 0;
		for(int count = 0;count<length; count++){
			double prob = random.nextDouble();
			if(density<prob){
				hold[count] = random.nextInt(1000000) + 1;
				range++;
			} else {
				hold[count] = 0;
			}
		}
		int[][] sparse = new int[range][2];
		int step = 0;
		for(int count = 0;count<length; count++){
			if(hold[count]!= 0){	
				sparse[step][0] = count;
				sparse[step][1] = hold[count];
				step++;
			}
		}
		return sparse;
	}
	public static int[][] changeToSparse(int[] dense){
		int range = 0;
		for(int index = 0;index<dense.length; index++){
			if(dense[index]!= 0){
				range++;
			}
		}
		int[][] changedSparse = new int[range][2];
		int step = 0;
		for(int count = 0;count<dense.length; count++){
			if(dense[count]!= 0){	
				changedSparse[step][0] = count;
				changedSparse[step][1] = dense[count];
				step++;
			}
		}
		return changedSparse;
	}
	
	public static int[] changeToDense(int[][] sparse, int length){
		int[] changedDense = new int[length];
		for(int index = 0;index<sparse.length; index++){
			changedDense[sparse[index][0]] = sparse[index][1];
		}
		return changedDense;
	}
	public static void maxDense(int[] dense){
		int max = 0;
		int pos = 0;
		for(int count = 0;count<dense.length; count++){
			if(dense[count]>max){
				max = dense[count];
				pos = count;
			}
		}
		System.out.println("The max of dense array: " + max + " at: " + pos);
	}
	public static void maxSparse(int[][] sparse){
		int max = 0;
		int pos = 0;
		for(int count = 0;count<sparse.length; count++){
			if(sparse[count][1]>max){
				max = sparse[count][1];
				pos = sparse[count][0];
			}
		}
		System.out.println("The max of sparse array: " + max + " at: " + pos);
	}
}
		