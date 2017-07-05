package cryptogram;

import java.util.ArrayList;
import java.util.HashMap;

public class ExternalWebService {
	Administrator admin;
	
	public ExternalWebService(){
		admin = new Administrator();
	}
	public void sendPlayerRating(){
		
	}
	public void sendCryptogram( String sol, String encode){
		admin.addCryptogram(sol, encode);
	}
	public Player getPlayerUserName(String username){
		return admin.getPlayers().get(username);
	}
	public HashMap<Integer, Cryptogram> requestCryptogram(){
		return admin.getCryptograms();
	}
	
}
