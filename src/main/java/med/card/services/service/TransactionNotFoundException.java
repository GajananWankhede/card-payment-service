package med.card.services.service;

public class TransactionNotFoundException extends Exception {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public TransactionNotFoundException(String msg) {
		
		super(msg);
		//returning proper message to user
   }
}

