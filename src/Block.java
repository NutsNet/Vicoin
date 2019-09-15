import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
	private String blockData;
	
	public String blockCurrentHash;
	private String blockPreviousBlockHash;
	
	private int blockNonce = 0;
	private long blockTimestamp = 0;
	private boolean isBlockProofOfWork = false;
	
	public int blockNum = 0;
	
	public Block(int num, String previousBlockHash, String data) throws NoSuchAlgorithmException {
		blockNum = num;

		blockData = data;
		
		blockPreviousBlockHash = previousBlockHash;
		
		blockMine(new ACMethodComplete() {
            @Override
            public void finished(Object result) { blockPrint(); }
        });
	}
	
	private void blockMine(final ACMethodComplete complete) throws NoSuchAlgorithmException {
		for (int i=0; i<Integer.MAX_VALUE; i++) {
			blockTimestamp = new Date().getTime();
			Hash hashTest = new Hash(blockPreviousBlockHash + Integer.toString(i) + blockTimestamp + blockData);
			String hashStr = hashTest.getHashResult().toString();
			
			String strZero = "";
			for (int j=0; j<Global.globalHashZeroNb; j++) {
				strZero = strZero + "0";
			}
			
			if (hashStr.substring(0, Global.globalHashZeroNb).equals(strZero)) {
				blockCurrentHash = hashStr;
				isBlockProofOfWork = true;
				blockNonce = i;
				
				complete.finished("MINED");
				
				break;
			}
		}
	}
	
	private void blockPrint() {
		if (blockNum == 1) {
		System.out.println("##########################################################################################"); }
		System.out.println("#");
		System.out.println("# Block number        : " + blockNum);
		System.out.println("# Block nonce         : " + blockNonce);
		System.out.println("# Proof of work       : " + isBlockProofOfWork);
		System.out.println("# Timestamp           : " + blockTimestamp);
		System.out.println("# Data                : " + blockData);
		System.out.println("# Previous block hash : " + blockPreviousBlockHash);
		System.out.println("# Current  block hash : " + blockCurrentHash);
		System.out.println("#");
		System.out.println("##########################################################################################");
	}
}
