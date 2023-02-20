package med.card.services.service;

public class CardNotFoundException extends Exception {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public CardNotFoundException(String msg) {
		
		super(msg);
		//returning proper message to user
   }
}