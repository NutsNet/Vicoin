import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

interface ACMethodComplete {
    void finished(Object result);
}

public class Main {
	// Hash types: "MD2" "MD5" "SHA" "SHA-224" "SHA-256" "SHA-384" "SHA-512"
	public static void main(String[] args) throws NoSuchAlgorithmException {
		ArrayList<String> blockchain1Datas = new ArrayList<String>();
		blockchain1Datas.add("Vicoin give 1000vc to Chris");
		blockchain1Datas.add("Chris give 100 to Mick");
		Blockchain blockchain1 = new Blockchain(1, blockchain1Datas);
		blockchain1.start();
		
		ArrayList<String> blockchain2Datas = new ArrayList<String>();
		blockchain2Datas.add("Vicoin give 100vc to Sal");
		blockchain2Datas.add("Sal give 10 to Ben");
		Blockchain blockchain2 = new Blockchain(2, blockchain2Datas);
		blockchain2.start();
	}
}
