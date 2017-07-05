package cryptogram;

import java.util.HashMap;

public class Administrator {
	
	
	private HashMap< String , Player> players;
	private HashMap<Integer, Cryptogram> cryptograms;

	public Administrator() {
		players = new HashMap<String, Player>();
		cryptograms = new HashMap<Integer, Cryptogram>();
		
	}
	
	public Administrator(HashMap<String, Player> players,
			HashMap<Integer, Cryptogram> cryptograms) {
		super();
		this.setPlayers(players);
		this.setCryptograms(cryptograms);
	}

	public void addPlayer(String username, String firstName, String lastName){
		
		players.put(username, new Player(username , firstName, lastName ));
		
	}
	
	public void editCryptogram(int cryptoid, String solution, String encoded){
		cryptograms.replace(cryptoid, new Cryptogram (cryptoid, solution, encoded) );
		
	}

	public int addCryptogram( String solution, String encoded){
		
		cryptograms.put( 0 , new Cryptogram (0, solution, encoded) );
		return 0;
	}
	
	
	public HashMap< String , Player> getPlayers() {
		return players;
	}

	public void setPlayers(HashMap< String , Player> players) {
		this.players = players;
	}

	public HashMap<Integer ,Cryptogram> getCryptograms() {
		return cryptograms;
	}

	public void setCryptograms(HashMap<Integer ,Cryptogram> cryptograms) {
		this.cryptograms = cryptograms;
	}

	
	 
}
