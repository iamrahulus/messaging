package com.aws.services.messaging.models;

public class AmazonSQSQueue implements Destination {

	String qName;
	DestinationType dType = DestinationType.sqsQueue;

	boolean FIFO = false;
	
	public AmazonSQSQueue(String qName, boolean isOrdered) {
		this.qName = qName;
		this.FIFO = isOrdered;
	}
	
	public AmazonSQSQueue(){}

	public String getQueueURL() {
		if (this.qName == null)
			return null;
		
		return null;
	}

	@Override
	public void setDestinationName(String destinationName) {
		// TODO Auto-generated method stub
		this.qName = destinationName;
	}

	@Override
	public void setDestinationType(DestinationType destinationType) {
		// TODO Auto-generated method stub
		this.dType = DestinationType.sqsQueue;
	}

	@Override
	public String getDestinationName() {
		// TODO Auto-generated method stub
		return this.qName;
	}

	@Override
	public DestinationType getDestinationType() {
		// TODO Auto-generated method stub
		return this.dType;
	}
	
	public void isOrdered(boolean isOrdered) {
		// TODO Auto-generated method stub
		this.FIFO = isOrdered;
	}
	
	public boolean getIsOrdered(){
		return this.FIFO;
	}

}