package com.dto;

import java.util.Objects;

public class UserForRegisterDto {
    
    private String username ;

    private String password ;

    public UserForRegisterDto() {
    }

    public UserForRegisterDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserForRegisterDto username(String username) {
        this.username = username;
        return this;
    }

    public UserForRegisterDto password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserForRegisterDto)) {
            return false;
        }
        UserForRegisterDto userForRegisterDto = (UserForRegisterDto) o;
        return Objects.equals(username, userForRegisterDto.username) && Objects.equals(password, userForRegisterDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
    
}