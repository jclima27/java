package br.com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

	
	@KafkaListener(
			topics = "${order.topic}", 
			groupId = "${spring.kafka.consumer.group-id}"
	)
    public void consumer(String order) {
        System.out.println("Order: " + order);
    }
    
	
	/*
	 * Consumir detalhes da mensagem
	 * 
	@KafkaListener(
			topics = "${order.topic}", 
			groupId = "${spring.kafka.consumer.group-id}"
	)
    public void consumer(ConsumerRecord consumerRecord) {
		System.out.println("key: " + consumerRecord.key());
        System.out.println("Headers: " + consumerRecord.headers());
        System.out.println("Partion: " + consumerRecord.partition());
        System.out.println("Order: " + consumerRecord.value());
    }
	*/
	
}
