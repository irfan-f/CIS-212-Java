import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public static void main(String args[]) {
		ArrayList<Integer> clientData = null;
		ArrayList<Integer> processedData = new ArrayList<Integer>();
		ServerSocket firstSocket = null;
		Socket connectedSocket = null;
		
		try {
			firstSocket = new ServerSocket(3456);
		} catch (IOException e) {
			System.out.println("Could not open socket");
			e.printStackTrace();
		}
		while(true) {
			try {
				connectedSocket = firstSocket.accept();
			} catch (IOException e) {
				System.out.println("Could not accept connection");
				e.printStackTrace();
			}
			
			ObjectOutputStream toC = null;
			try { 
				toC = new ObjectOutputStream(connectedSocket.getOutputStream());
				toC.flush();
			} catch (IOException e) {
				System.out.println("Closed Stream");
				e.printStackTrace();
			}
			
			ObjectInputStream fromC = null;
			try {
				fromC = new ObjectInputStream(connectedSocket.getInputStream());
			} catch (IOException e) {
				System.out.println("Closed Stream");
				System.exit(0);
				e.printStackTrace();
			}
			
			try {
				clientData = (ArrayList<Integer>)fromC.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("Got unexpected data");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Could not receive");
				System.exit(0);
				e.printStackTrace();
			}
			for (int i = 0; i < clientData.size(); i++) {
				if (isPrime(clientData.get(i))) {
					processedData.add(clientData.get(i));
				}
			}

			try {
				toC.writeObject(processedData);
			} catch (IOException e) {
				System.out.println("Could not write object to output stream");
				e.printStackTrace();
				System.exit(0);
			}
			
			try {
				connectedSocket.close();
			} catch (IOException e) {
				System.out.println("Could not close socket");
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
	private static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		
		else if (n == 1 || n % 2 == 0) {
			return false;
		}
		
		else {
			for (int i = 3; i * i <= n; i += 2) {
				if (n % i == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
}