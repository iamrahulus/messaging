package com.aws.services.messaging.models;

public interface AmazonMessageProducer {

	public boolean produceMessage(Destination destination, Message message);

}
