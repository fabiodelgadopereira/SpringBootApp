package com.cliente.springboot.controller;

import com.cliente.springboot.model.Contato;
import com.cliente.springboot.model.EmailConfig;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping()
public class ContatoController {

    private EmailConfig emailConfig;

    public ContatoController(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }
    
    @PostMapping(value="/Contato")
    public String postCliente(@RequestBody @Valid Contato contato){
        
                // Create a mail sender
                JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
                mailSender.setHost(this.emailConfig.getHost());
                mailSender.setPort(this.emailConfig.getPort());
                mailSender.setUsername(this.emailConfig.getUsername());
                mailSender.setPassword(this.emailConfig.getPassword());
        
                // Criando um e-emil
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom(contato.getEmail());
                mailMessage.setTo("rc@feedback.com");
                mailMessage.setSubject("New feedback from " + contato.getNome());
                mailMessage.setText(contato.getMensagem());
        
                // Enviar e-mail
                mailSender.send(mailMessage);
        return String.format("Mensagem enviada com sucesso!");
    }
}