package cryptogram;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	
	private String username;
	private String firstName;
	private String lastname;
	private HashMap<Integer, Solution>solution;
	private double rating; 
	
	public Player(String username, String firstName, String lastname) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastname = lastname;
	}
	
	public boolean solveCryptogram(Cryptogram crypto,String previousAttempt, String newAttempt ){
		
		if(previousAttempt == null){
			
			ArrayList<String> newsol = new ArrayList<String>();
			newsol.add(newAttempt);
			solution.put(crypto.getCryptid(), new Solution(crypto.getCryptid() , newsol));
			
		}else{
			
			solution.get(crypto).getSolutions().remove(previousAttempt);
			solution.get(crypto).getSolutions().add(newAttempt);
			
		}
		return crypto.getSoultion() == newAttempt; 
	}

	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public HashMap<Integer, Solution> getSolution() {
		return solution;
	}

	public void setSolution(HashMap<Integer, Solution> solution) {
		this.solution = solution;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}
