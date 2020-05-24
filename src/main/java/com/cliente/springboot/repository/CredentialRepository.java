package com.cliente.springboot.repository;

import java.io.IOException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import com.dto.UserForAuthDto;
import com.dto.UserForRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@Repository
public class CredentialRepository {
    
    private static final String SQL_USER_EXISTS = "EXEC [dbo].[sp_User_Exists] :Username";
    private static final String SQL_REGISTER = "EXEC [dbo].[sp_User_Register] :Username, :PasswordHash, :PasswordSait";
    private static final String SQL_LOGIN = "EXEC [dbo].[sp_User_Login] :Username";

    private static final BeanPropertyRowMapper<UserForAuthDto> ROW_MAPPER = new BeanPropertyRowMapper<>(UserForAuthDto.class);

    private static final String HMAC_SHA512 = "HmacSHA512";

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

	public boolean userExists(final String username) {
        final SqlParameterSource paramSource = new MapSqlParameterSource()
        .addValue("Username", username);

        final Integer result = jdbcTemplate.queryForObject(SQL_USER_EXISTS, paramSource, Integer.class);

        if(result==0) return true;

        return false;
	}

	public void register(final UserForRegisterDto value) {
        final String PasswordHash = "";
        final String PasswordSait = "";

        final SqlParameterSource paramSource = new MapSqlParameterSource()
        .addValue("Username", value.getUsername())
        .addValue("PasswordHash", PasswordHash)
        .addValue("PasswordSait", PasswordSait);

        jdbcTemplate.update(SQL_REGISTER, paramSource);
	}

	public boolean login(final String username, final String password) throws IOException {
		final SqlParameterSource paramSource = new MapSqlParameterSource()
        .addValue("Username", username);

        UserForAuthDto result= jdbcTemplate.queryForObject(SQL_LOGIN, paramSource,ROW_MAPPER);
                
        return VerifyPasswordHash(password,result.getPasswordHash(),result.getPasswordSalt() );

    }
    private boolean VerifyPasswordHash(String password, byte[] passwordHash, byte[] passwordSalt)
    {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(passwordSalt, HMAC_SHA512);
            Mac mac = Mac.getInstance(HMAC_SHA512);
            mac.init(secretKeySpec);
            byte[] result =mac.doFinal(password.getBytes());
            for (int i = 0; i < result.length; i++)
            {
                if (result[i] != passwordHash[i]) return false;
            }
            return true;

        } catch (InvalidKeyException  | NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return false;
    }
}


    
