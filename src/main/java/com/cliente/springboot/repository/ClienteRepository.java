package com.cliente.springboot.repository;

import com.cliente.springboot.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {

    private static final String SQL_FIND_ALL = "EXEC [dbo].[sp_Clientes_GetAllValues]";
    private static final String SQL_INSERT = "EXEC [dbo].[sp_Clientes_InsertValue]    :Nome  ,:Cidade  ,:Email  ,:Sexo";
    private static final String SQL_FIND_BY_ID  = "EXEC [dbo].[sp_Clientes_GetValueById] :Id";
    private static final String SQL_DELETE_BY_ID = "EXEC [dbo].[sp_Clientes_DeleteValue]  :Id";
    private static final String SQL_ALTER = "EXEC [dbo].[sp_Clientes_InsertValue]  :Id,  :Nome  ,:Cidade  ,:Email  ,:Sexo";
    
    private static final BeanPropertyRowMapper<Cliente> ROW_MAPPER = new BeanPropertyRowMapper<>(Cliente.class);

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Iterable<Cliente> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, ROW_MAPPER);
    }
    public Cliente findById(Integer id) {
        try {
            final SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, paramSource, ROW_MAPPER);
        }
        catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    public int save(Cliente cliente) {
        final SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("Nome", cliente.getNome())
                .addValue("Cidade", cliente.getCidade())
                .addValue("Email", cliente.getEmail())
                .addValue("Sexo", cliente.getSexo());

        return jdbcTemplate.update(SQL_INSERT, paramSource);
    }
    public int alter(Cliente cliente) {
        final SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("Id", cliente.getId())
                .addValue("Nome", cliente.getNome())
                .addValue("Cidade", cliente.getCidade())
                .addValue("Email", cliente.getEmail())
                .addValue("Sexo", cliente.getSexo());

        return jdbcTemplate.update(SQL_ALTER, paramSource);
    }

    public void deleteById(Integer id) {
        final SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
        jdbcTemplate.update(SQL_DELETE_BY_ID, paramSource);
    }
    
}