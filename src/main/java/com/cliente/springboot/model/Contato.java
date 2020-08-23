package com.cliente.springboot.model;

public class Contato {
    private String Nome;

    private String Email;

    private String Mensagem;

    public String getNome() {
        return Nome;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        this.Mensagem = mensagem;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public Contato(String nome, String email, String mensagem) {
        Nome = nome;
        Email = email;
        Mensagem = mensagem;
    }
}