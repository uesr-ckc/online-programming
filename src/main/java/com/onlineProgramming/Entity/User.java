package com.onlineProgramming.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

/**
 * @author CKC
 * @DateTime 2021/4/28 16:39
 */
@Data
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String userId;
    private String username;
    private String email;
    private String password;
    private String filepath;
    private Integer userType;
    private String loginTime;
    
    public User() {
        userType = 2;
        filepath = UUID.randomUUID().toString().replaceAll("-", "").trim().substring(0, 8);
    }
}
