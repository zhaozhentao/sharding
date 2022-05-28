package hi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hi.entity.User;
import hi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    List<User> userList = new ArrayList<>();

    @PostConstruct
    private void getData() {
        userList.add(new User(1L, "小小"));
        userList.add(new User(2L, "爸爸"));
        userList.add(new User(3L, "妈妈"));
        userList.add(new User(4L, "爷爷"));
        userList.add(new User(5L, "奶奶"));
    }

    @GetMapping("save-user")
    public Object saveUser() {
        return userService.saveBatch(userList);
    }

    @GetMapping("list-user")
    public Object listUser() {
        return userService.page(new Page<>(1, 1));
    }
}
