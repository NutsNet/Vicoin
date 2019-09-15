import java.security.NoSuchAlgorithmException;
import java.util.Timer;
import java.util.TimerTask;

public class Blockchain {
	int blochainBlockId = 0;
	String blochainBlockHash = "0000000000000000000000000000000000000000000000000000000000000000";
	
	public Blockchain() {
		
	}
	
	public void launch() {
		TimerTask repeatedTask = new TimerTask() {
		    public void run() {
		    	try {
					blockchainCheckData();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
		    }
		};
		
		Timer timer = new Timer("Timer");
		timer.scheduleAtFixedRate(repeatedTask, 0, 100);
	}
	
	private void blockchainCheckData() throws NoSuchAlgorithmException {
		if (Global.globalBlockchainData.size() > 0) {
			Block block = new Block(blochainBlockId, blochainBlockHash, Global.globalBlockchainData.get(0));
			blochainBlockHash = block.blockCurrentHash;
			Global.globalBlockchainData.remove(0);
			blochainBlockId++;
		}
	}
}
