package org.example.controller;

import org.example.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class ProducerController {


    @Autowired
    private ProducerService producerService;


    @GetMapping("/send")
    public void send(){
        producerService.send("hello");
    }
}
