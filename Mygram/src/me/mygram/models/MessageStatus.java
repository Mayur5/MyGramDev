package me.mygram.models;

public abstract class MessageStatus implements GenericStatus{
	
	private static String state = "NOT_INITIALIZED";
	final private static String SEND_IS_PENDING = "SEND_IS_PENDING";
	final private static String SEND_IS_COMPLETE = "SEND_IS_COMPLETE";
	final private static String RECEIPT_IS_PENDING = "RECEIPT_IS_PENDING";
	final private static String RECEIPT_IS_COMPLETE = "RECEIPT_IS_COMPLETE";
		
	
	public boolean confirmSent() {
		return state.equals(SEND_IS_COMPLETE);
	}
	
	public boolean confirmReceipt() {
		return state.equals(RECEIPT_IS_COMPLETE);
	}
	
	public boolean isPending() {
		return state.equals(SEND_IS_PENDING) | state.equals(RECEIPT_IS_PENDING);
	}
	
	public void setSentComplete() {
		state = SEND_IS_COMPLETE;
	}
	
	public void setReceiptComplete() {
		state = RECEIPT_IS_COMPLETE;
	}

	@Override
	public String toString() {
		return state;
	}

	@Override
	public abstract String statusCode();

}
