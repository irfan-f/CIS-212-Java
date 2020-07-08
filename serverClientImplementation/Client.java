import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

	public static void main(String args[]) {
		
		Socket connectedSocket = null;
		ObjectInputStream fromS = null;
		ObjectOutputStream toS = null;
		boolean inputDone = false;
		ArrayList<Integer> userInput = new ArrayList<Integer>();
		
		try {
			connectedSocket = new Socket("localhost", 3456);
		} catch (UnknownHostException e) {
			System.out.println("Could not identify host");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not connect to server");
			e.printStackTrace();
		}
		
		//create in stream
		
		try {
			fromS = new ObjectInputStream(connectedSocket.getInputStream());
		} catch (IOException e) {
			System.out.println("Could not initialise input stream");
			e.printStackTrace();
		}
		
		//create out stream
		
		try {
			toS = new ObjectOutputStream(connectedSocket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Could not initialise output stream");
			e.printStackTrace();
		}
		
		System.out.println("Connected to server.");
		
		Scanner scanner = new Scanner(System.in);
		while(!inputDone) {
			
			System.out.println("Enter an integer('!' to send):");
			String input = scanner.next();
			
			if (input.charAt(0) == '!') {
				inputDone = true;
			}
			
			else {
				try {
				userInput.add(Integer.parseInt(input));
				} catch (NumberFormatException e) {
					
				}
			}
			
		}
		scanner.close();
		
		System.out.println("Send: " + userInput.toString());
		
		try {
			toS.writeObject(userInput);
		} catch (IOException e) {
			System.out.println("Could not write to stream");
			e.printStackTrace();
		}
		
		
		try {
			System.out.println("Receive: " + (ArrayList<Integer>)fromS.readObject());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read from stream");
			e.printStackTrace();
		}
		
	}
}
