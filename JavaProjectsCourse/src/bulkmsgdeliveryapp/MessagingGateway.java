package bulkmsgdeliveryapp;

import java.util.ArrayList;

public class MessagingGateway {
	Client customer;
	String messageContent;
	String requestId;
	ArrayList<String> recipents;
	
	
	
	/**
	 * getters and setters
	 */
	public void setMessageContent(String messageContent) {
		if(messageContent.length() > 1024 || messageContent == null || messageContent == ""){
			System.out.println("messageContent cant be empty/null or larger than 1024 characters.");
		} else {
			this.messageContent = messageContent;
		}
	}
}
