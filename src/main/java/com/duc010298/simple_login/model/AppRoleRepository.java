package com.duc010298.simple_login.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppRoleRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AppRoleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getRoleNames(Long userId) {
        String sql = "Select r.Role_Name from User_Role ur, App_Role r where ur.Role_Id = r.Role_Id and ur.User_Id = ?";
        return jdbcTemplate.queryForList(sql, String.class, userId);
    }
}

