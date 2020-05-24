package com.dto;

import java.util.Objects;

public class UserForLoginDto {
    private String username ;
    private String password ;

    public UserForLoginDto() {
    }

    public UserForLoginDto(String username, String password) {
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

    public UserForLoginDto username(String username) {
        this.username = username;
        return this;
    }

    public UserForLoginDto password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserForLoginDto)) {
            return false;
        }
        UserForLoginDto userForLoginDto = (UserForLoginDto) o;
        return Objects.equals(username, userForLoginDto.username) && Objects.equals(password, userForLoginDto.password);
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