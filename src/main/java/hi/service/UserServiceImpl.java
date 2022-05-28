package hi.service;

import hi.entity.User;
import hi.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl {

    @Resource
    private UserMapper userMapper;

    public List<User> list() {
        return userMapper.selectAll();
    }

    public String insertForeach(List<User> userList) {
        userMapper.insertForeach(userList);
        return "保存成功";
    }
}
