/**
 * 
 */
package com.aws.services.messaging.models;

/**
 * @author rahurahu
 *
 */
public interface Destination {

	public void setDestinationName(String destinationName);

	public void setDestinationType(DestinationType destinationType);

	public String getDestinationName();

	public DestinationType getDestinationType();

}