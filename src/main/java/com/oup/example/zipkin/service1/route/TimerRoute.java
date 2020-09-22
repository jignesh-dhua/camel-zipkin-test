package com.oup.example.zipkin.service1.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TimerRoute extends RouteBuilder {

	protected Logger log = LoggerFactory.getLogger(getClass());
	
    @Override
    public void configure() {
        
    	from("timer:trigger?repeatCount=1")
        .streamCaching()
        .routeId(getClass().getName())
            .bean("counterBean")
            .log(LoggingLevel.INFO, log, "Before tx: ${body}")
            .to(TransformerRoute.FROM_ENDPOINT)
            .log(LoggingLevel.INFO, log, "After tx: ${body}");
    }
}