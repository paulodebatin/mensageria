/**
 * Para maiores informações:
 * https://www.rabbitmq.com/java-client.html
 * https://www.rabbitmq.com/tutorials/tutorial-one-java.html
 */

package br.com.mensageria.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {
	
	private final static String QUEUE_NAME = "queue-3";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    try (Connection connection = factory.newConnection();
	         Channel channel = connection.createChannel()) {

    	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    	    
    	    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
    	        String message = new String(delivery.getBody(), "UTF-8");
    	        System.out.println(" [x] Received '" + message + "'");
    	    };
    	    channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
	    }
		
	}

}
