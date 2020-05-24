package com.cliente.springboot.model;

import java.util.Objects;

public class Cliente {
  
    private int Id ;
    
    private String Nome;
    
    private String Cidade;

    private String Email;

    private String Sexo;

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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Id == cliente.Id && Objects.equals(Nome, cliente.Nome) && Objects.equals(Cidade, cliente.Cidade) && Objects.equals(Email, cliente.Email) && Objects.equals(Sexo, cliente.Sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Nome, Cidade, Email, Sexo);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", Nome='" + getNome() + "'" +
            ", Cidade='" + getCidade() + "'" +
            ", Email='" + getEmail() + "'" +
            ", Sexo='" + getSexo() + "'" +
            "}";
    }



    



}