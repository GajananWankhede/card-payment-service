package med.card.services.service;
public class BalanceNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public BalanceNotFoundException(String msg) {
		
		super(msg);
		//returning proper message to user
   }

}

