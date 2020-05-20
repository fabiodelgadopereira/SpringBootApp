package com.cliente.springboot.model;

public class Cliente {
  
    public int Id ;

    public String Nome;
    
    public String Cidade;

    public String Email;

    public String Sexo;

    public Cliente() {
    }

    public Cliente(int Id, String Nome, String Cidade, String Email, String Sexo) {
        this.Id = Id;
        this.Nome = Nome;
        this.Cidade = Cidade;
        this.Email = Email;
        this.Sexo = Sexo;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCidade() {
        return this.Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSexo() {
        return this.Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Cliente Id(int Id) {
        this.Id = Id;
        return this;
    }

    public Cliente Nome(String Nome) {
        this.Nome = Nome;
        return this;
    }

    public Cliente Cidade(String Cidade) {
        this.Cidade = Cidade;
        return this;
    }

    public Cliente Email(String Email) {
        this.Email = Email;
        return this;
    }

    public Cliente Sexo(String Sexo) {
        this.Sexo = Sexo;
        return this;
    }



}