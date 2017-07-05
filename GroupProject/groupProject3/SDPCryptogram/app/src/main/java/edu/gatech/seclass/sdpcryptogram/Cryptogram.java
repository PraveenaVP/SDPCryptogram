package cryptogram;

public class Cryptogram {
	
	private int cryptid;
	private String soultion;
	private String encoded;
	
	
	
	public Cryptogram(int cryptid, String soultion, String encoded) {
		super();
		this.cryptid = cryptid;
		this.soultion = soultion;
		this.encoded = encoded;
	}
	
	public int getCryptid() {
		return cryptid;
	}
	public void setCryptid(int cryptid) {
		this.cryptid = cryptid;
	}
	public String getSoultion() {
		return soultion;
	}
	public void setSoultion(String soultion) {
		this.soultion = soultion;
	}
	public String getEncoded() {
		return encoded;
	}
	public void setEncoded(String encoded) {
		this.encoded = encoded;
	}


	
}
