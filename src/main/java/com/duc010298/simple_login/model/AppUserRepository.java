package com.duc010298.simple_login.model;

import com.duc010298.simple_login.entity.AppUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppUserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AppUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public AppUserEntity findUserAccount(String userName) {
        String sql = "Select u.User_Id, u.User_Name, u.Encryted_Password From App_User u where u.User_Name = ?";
        List<AppUserEntity> appUserEntities = jdbcTemplate.query(sql, getRowMapper(), userName);
        if(appUserEntities.isEmpty()) return null;
        return appUserEntities.get(0);
    }

    private RowMapper<AppUserEntity> getRowMapper() {
        return new BeanPropertyRowMapper<>(AppUserEntity.class);
    }
}
