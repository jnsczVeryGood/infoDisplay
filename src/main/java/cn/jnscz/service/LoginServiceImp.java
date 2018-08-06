package cn.jnscz.service;

import cn.jnscz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private UserMapper um;
    public Boolean login(String username,String password)throws Exception{
        String s_password=null;
        s_password=um.selectPasswordById(username);
        if (s_password.equals(password)){
            return true;
        }
        return false;
    }
}
