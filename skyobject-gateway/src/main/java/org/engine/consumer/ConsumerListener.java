package org.engine.consumer;

import org.engine.plugin.transactions.factory.AuthRequestFactory;
import org.engine.plugin.transactions.factory.AuthResponseFactory;
import org.engine.plugin.transactions.factory.SaleRequestFactory;
import org.engine.plugin.transactions.factory.SaleResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "tp-sale.request", topics = "tp-sale.request")
public class ConsumerListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerListener.class);

	@KafkaHandler
	@SendTo("tp-sale.reply")
	public AuthResponseFactory fooListener(AuthRequestFactory authRequestFactory) {
		System.out.println("In AuthRequestFactoryListener: " + authRequestFactory);

		AuthResponseFactory resObj = new AuthResponseFactory();
		resObj.setUnique_id("193123 auh");

		return resObj;
	}

	@KafkaHandler
	@SendTo("tp-sale.reply")
	public SaleResponseFactory barListener(SaleRequestFactory saleRequestFactory) {
		System.out.println("In SaleRequestFactoryListener: " + saleRequestFactory);

		SaleResponseFactory resObj = new SaleResponseFactory();
		resObj.setUnique_id("123123 sale");

		return resObj;
	}
}
