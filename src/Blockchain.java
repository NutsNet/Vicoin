import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Blockchain extends Thread {
	int blochchainId;
	ArrayList<String> blockchainDatas;
	
	
	public Blockchain(int id, ArrayList<String> datas) throws NoSuchAlgorithmException {
		blochchainId = id;
		blockchainDatas = datas;
	}
	
	public void run() {
		Block block= null;
		String hash = "0000000000000000000000000000000000000000000000000000000000000000";
		
		for (int i=0; i<blockchainDatas.size(); i++) {
			try {
				block = new Block(blochchainId, i+1, hash, blockchainDatas.get(i));
				hash = block.blockCurrentHash;
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}
}
