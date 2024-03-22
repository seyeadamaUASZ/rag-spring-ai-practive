package com.example.ragspringaipractive;


import com.example.ragspringaipractive.service.RagService;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class RagSpringAiPractiveApplication {
    public static void main(String[] args) {
        SpringApplication.run(RagSpringAiPractiveApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(RagService ragService,
                                        @Value("classpath:marieseye.pdf") Resource pdf){
        return args -> {
          //embeddingTexte(vectorStore,jdbcTemplate,pdf);
          String query = "donne moi au format json, l'objet de la lettre";
          ragService.embeddingTexte(pdf);
          String response=  ragService.askLLM(query);
          System.out.println(response);

        };

    }



}
