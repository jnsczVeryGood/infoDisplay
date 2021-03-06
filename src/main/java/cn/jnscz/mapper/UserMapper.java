package cn.jnscz.mapper;

import org.mybatis.spring.annotation.MapperScan;
import cn.jnscz.domain.User;

@MapperScan
public interface UserMapper {
	public User selectUserById(String username) throws Exception;
	public String selectPasswordById(String username)throws Exception;
	public boolean insertUser(User user) throws Exception;
}
