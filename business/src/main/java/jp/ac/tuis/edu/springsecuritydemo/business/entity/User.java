package jp.ac.tuis.edu.springsecuritydemo.business.entity;

import lombok.Data;

@Data
public class User {
    
    private String username;
    private String password;
    private String code;
}
