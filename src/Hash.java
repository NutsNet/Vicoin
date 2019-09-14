import java.math.BigInteger;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class Hash {
	private String hashType;
	private String hashResult;
	
	public Hash(String str) throws NoSuchAlgorithmException {
		hashType = Global.globalHashType;
		setHashResult(str);
	}
	
	public String getHashResult() {
		return hashResult;
	}
	
	public void setHashResult(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(hashType);
        byte[] hashBytes = md.digest(str.getBytes(StandardCharsets.UTF_8));
        
        BigInteger hashBigInt = new BigInteger(1, hashBytes);
		
        StringBuilder hexString = new StringBuilder(hashBigInt.toString(16));
        while (hexString.length() < Global.globalHashHexLenght) { hexString.insert(0, '0'); }
        hashResult = hexString.toString();  
	}
}
