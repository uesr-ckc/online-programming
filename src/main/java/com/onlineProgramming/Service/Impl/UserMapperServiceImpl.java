package com.onlineProgramming.Service.Impl;

import com.onlineProgramming.Dao.UserMapper;
import com.onlineProgramming.Entity.User;
import com.onlineProgramming.Service.UserMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CKC
 * @DateTime 2021/4/28 18:27
 */
@Service
public class UserMapperServiceImpl implements UserMapperService {
    @Resource
    private UserMapper userMapper;
    
    @Override
    public User inquiryUser(User user) {
        return userMapper.inquiryUser(user);
    }
    
    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
    
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
