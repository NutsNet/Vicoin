import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

interface ACMethodComplete {
    void finished(Object result);
}

public class Main {
	private static Blockchain blockchain;
	
	// Hash types: "MD2" "MD5" "SHA" "SHA-224" "SHA-256" "SHA-384" "SHA-512"
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		User userTed = new User("Ted", 1000);
		User userTom = new User("Tom", 10000);
		
		Global.globalBlockchainData = new ArrayList<String>();
		blockchain = new Blockchain();
		blockchain.launch();
		mainInput();
	}
	                             
	private static void mainInput() throws IOException, NoSuchAlgorithmException {
		System.out.print("Next transaction: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        
        Global.globalBlockchainData.add(inputString);

		mainInput();
	}
}
