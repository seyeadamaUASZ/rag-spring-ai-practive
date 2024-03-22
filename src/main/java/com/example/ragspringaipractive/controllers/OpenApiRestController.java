package com.example.ragspringaipractive.controllers;

import com.example.ragspringaipractive.service.RagService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OpenApiRestController {
    @Autowired
    private ChatClient chatClient;

    @Autowired
    private RagService ragService;

    @GetMapping("/chat")
    public String chat(String query){
       return chatClient.call(query);
    }

  /*  @GetMapping("/ask")
    public Map ask(String query) throws JsonProcessingException {
        String response= ragService.askLLM(query);
        return new ObjectMapper().readValue(response, Map.class);
    }*/

    @GetMapping("/ask")
    public String ask(String query) throws JsonProcessingException {
        String response= ragService.askLLM(query);
        return response;
    }

}
