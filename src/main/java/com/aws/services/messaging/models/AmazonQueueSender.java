package com.aws.services.messaging.models;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;

public class AmazonQueueSender implements AmazonMessageProducer {

	AmazonSQS sqsClient = AmazonSQSClientBuilder.defaultClient();
	
	Map queueAttributes = new HashMap();

	
	@Override
	public boolean produceMessage(Destination destination, Message message) {
		if (!(destination instanceof AmazonSQSQueue))
			return false;

		
		AmazonSQSQueue sqsQueue = (AmazonSQSQueue) destination;
		String q = sqsQueue.getDestinationName();

		sqsClient.sendMessage(createQueueUrl(q, sqsQueue), message.getMessageBody());
		return true;
	}

	private String createQueueUrl(String queueName, AmazonSQSQueue destination) {
		String url = null;
		GetQueueUrlResult urlResult = null;
		try {
			urlResult = sqsClient.getQueueUrl(queueName);
			if (urlResult != null)
				url = urlResult.getQueueUrl();
		} catch (QueueDoesNotExistException qne) {
			// Set FIFO attribute if needed
			if (destination.getIsOrdered() && queueName != null && queueName.endsWith(".fifo"))
				setAttributes();
			CreateQueueResult qResult = sqsClient.createQueue(queueName);
			if (qResult != null)
				url = qResult.getQueueUrl();
		} finally {
			return url;
		}
	}

	private void setAttributes() {
		SetQueueAttributesRequest attrRequest = new SetQueueAttributesRequest();
		queueAttributes.put("FifoQueue", "true");
		queueAttributes.put("ContentBasedDeduplication", "true");
		sqsClient.setQueueAttributes(attrRequest);
	}
}