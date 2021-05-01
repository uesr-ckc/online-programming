package com.onlineProgramming.Service;

import com.onlineProgramming.Entity.User;

/**
 * @author CKC
 * @DateTime 2021/4/28 18:26
 */

public interface UserMapperService {
    User inquiryUser(User user);
    
    int insertUser(User user);
    
    void updateUser(User user);
}
