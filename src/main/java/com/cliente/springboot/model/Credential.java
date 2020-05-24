package com.cliente.springboot.model;

import java.util.Objects;

public class Credential {

    private int Id ;
    private String Username ;
    private String Password ;

    public Credential() {
    }

    public Credential(int Id, String Username, String Password) {
        this.Id = Id;
        this.Username = Username;
        this.Password = Password;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Credential Id(int Id) {
        this.Id = Id;
        return this;
    }

    public Credential Username(String Username) {
        this.Username = Username;
        return this;
    }

    public Credential Password(String Password) {
        this.Password = Password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) o;
        return Id == credential.Id && Objects.equals(Username, credential.Username) && Objects.equals(Password, credential.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Username, Password);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", Username='" + getUsername() + "'" +
            ", Password='" + getPassword() + "'" +
            "}";
    }

    
}