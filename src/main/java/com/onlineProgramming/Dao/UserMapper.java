package com.onlineProgramming.Dao;

import com.onlineProgramming.Entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author CKC
 * @DateTime 2021/4/28 17:18
 */
@Mapper
public interface UserMapper {
    User inquiryUser(User user);
    
    int insertUser(User user);
    
    void updateUser(User user);
}
