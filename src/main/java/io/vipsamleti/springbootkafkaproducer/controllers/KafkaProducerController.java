package io.vipsamleti.springbootkafkaproducer.controllers;

import io.vipsamleti.springbootkafkaproducer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/producer")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "KAFKA_TOPIC";

    @GetMapping("/{name}")
    public String producer(@PathVariable("name") final String name){

        kafkaTemplate.send(TOPIC, new User("1", name, "10000"));
        return "Sent";
    }



}
