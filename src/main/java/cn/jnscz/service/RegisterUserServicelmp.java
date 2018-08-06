package cn.jnscz.service;

import cn.jnscz.mapper.UserMapper;
import cn.jnscz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserServicelmp implements RegisterUserService {

    @Autowired
    private UserMapper um;

     public boolean registerUser(User user) throws Exception{
       if( um.insertUser(user))
           return  true;
       else
           return false;

    }
}

