package com.cliente.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@EnableSwagger2
@RestController
@RequestMapping()
public class FileUploadController {

    private static String UPLOADED_FOLDER = System.getProperty("java.io.tmpdir");

    @PostMapping("/FileUpload") 
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            return "Erro ao tentar fazer upload";
        }
        try {
            // Pega os bytes recebido e salva no diretório
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            return "Arquivo:'" + file.getOriginalFilename() + "' upload realizado com sucesso!";

        } catch (IOException e) {
            return "Erro ao tentar fazer upload";
        }

    }

}