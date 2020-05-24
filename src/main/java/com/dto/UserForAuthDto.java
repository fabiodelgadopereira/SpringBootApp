package com.dto;

import java.util.Objects;

public class UserForAuthDto {
    private byte[] passwordHash;
    private byte[] passwordSalt;

    public UserForAuthDto() {
    }

    public UserForAuthDto(byte[] passwordHash, byte[] passwordSalt) {
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
    }

    public byte[] getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public byte[] getPasswordSalt() {
        return this.passwordSalt;
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public UserForAuthDto passwordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public UserForAuthDto passwordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserForAuthDto)) {
            return false;
        }
        UserForAuthDto userForAuthDto = (UserForAuthDto) o;
        return Objects.equals(passwordHash, userForAuthDto.passwordHash) && Objects.equals(passwordSalt, userForAuthDto.passwordSalt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passwordHash, passwordSalt);
    }

    @Override
    public String toString() {
        return "{" +
            " passwordHash='" + getPasswordHash() + "'" +
            ", passwordSalt='" + getPasswordSalt() + "'" +
            "}";
    }
}