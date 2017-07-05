package cryptogram;

import java.util.ArrayList;

public class Solution {
	
	private Integer cryptoId;
	private ArrayList<String> solutions;
	
	public Solution(int cryptoId, ArrayList<String> solutions) {
		super();
		this.setCryptoId(cryptoId);
		this.solutions = solutions;
	}
	

	public ArrayList<String> getSolutions() {
		return solutions;
	}
	public void setSolutions(ArrayList<String> solutions) {
		this.solutions = solutions;
	}


	public Integer getCryptoId() {
		return cryptoId;
	}


	public void setCryptoId(Integer cryptoId) {
		this.cryptoId = cryptoId;
	}

	
}
