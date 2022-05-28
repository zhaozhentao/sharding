package hi.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hi.entity.User;
import hi.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
