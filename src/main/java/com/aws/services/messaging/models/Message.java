package com.aws.services.messaging.models;

import java.sql.Timestamp;

public class Message {

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Timestamp getMessageTimestamp() {
		return messageTimestamp;
	}

	public void setMessageTimestamp(Timestamp messageTimestamp) {
		this.messageTimestamp = messageTimestamp;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(String messageContext) {
		this.messageContext = messageContext;
	}

	public String getMessageGroupId() {
		return messageGroupId;
	}

	public void setMessageGroupId(String messageGroupId) {
		this.messageGroupId = messageGroupId;
	}

	private String source;

	private String destination;

	private String messageContext;

	private String messageGroupId;

	private String messageBody;

	private Timestamp messageTimestamp;

}
