package hi.service;

import org.springframework.stereotype.Service;
import hi.entity.User;
import hi.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl {

    @Resource
    private UserMapper userMapper;

    public List<User> list() {
        return userMapper.selectAll();
    }

    public String insertForeach(List<User> userList) {
        for (User user : userList) {
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setStatus(0);
        }
        //批量插入数据
        userMapper.insertForeach(userList);
        return "保存成功";
    }
}
