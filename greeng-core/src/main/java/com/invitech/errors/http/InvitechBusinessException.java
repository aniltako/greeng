package com.invitech.errors.http;


public class InvitechBusinessException extends RuntimeException{
	private static final long serialVersionUID = 8306706927505101863L;
	
	public InvitechBusinessException() {
        super();
    }
    public InvitechBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvitechBusinessException(String message) {
        super(message);
    }
    public InvitechBusinessException(Throwable cause) {
        super(cause);
    }

}
